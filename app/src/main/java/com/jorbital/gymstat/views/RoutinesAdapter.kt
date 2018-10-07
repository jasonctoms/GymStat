package com.jorbital.gymstat.views

import android.content.Intent
import android.graphics.Typeface
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.jorbital.gymstat.GymStatStringConstants
import com.jorbital.gymstat.R
import com.jorbital.gymstat.data.Routine
import com.jorbital.gymstat.utils.DayOfWeekRealm

import io.realm.OrderedRealmCollection
import io.realm.RealmList
import io.realm.RealmRecyclerViewAdapter
import kotlinx.android.synthetic.main.routines_list_item.view.*
import org.threeten.bp.DayOfWeek
import org.threeten.bp.Duration
import org.threeten.bp.LocalDateTime


class RoutinesAdapter internal constructor(private val mData: OrderedRealmCollection<Routine>?, autoUpdate: Boolean) : RealmRecyclerViewAdapter<Routine, RoutinesAdapter.RoutineViewHolder>(mData, autoUpdate) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoutineViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.routines_list_item, parent, false)
        return RoutineViewHolder(v)
    }

    override fun onBindViewHolder(holder: RoutineViewHolder, position: Int) {
        val routine = getItem(position) ?: return
        holder.bind(routine, holder)
    }

    override fun getItemCount(): Int = mData!!.size

    inner class RoutineViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

        internal fun bind(routine: Routine, holder: RoutineViewHolder) {
            holder.itemView.setOnClickListener { view -> itemClicked(view) }
            itemView.startRoutineButton.setOnClickListener { view -> buttonClicked(view) }
            itemView.routineName.text = routine.name

            val now = LocalDateTime.now()
            val then = LocalDateTime.parse(routine.lastCompletedDate)
            val days = Duration.between(then, now).toDays()
            itemView.lastPerformed.text = String.format(itemView.context.getString(R.string.routines_last_performed), days)

            val weekdays = routine.days
            setWeekdays(weekdays)

            itemView.routineExercisesRV.setHasFixedSize(true)
            itemView.routineExercisesRV.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(itemView.context, androidx.recyclerview.widget.LinearLayoutManager.VERTICAL, false)
            itemView.routineExercisesRV.isNestedScrollingEnabled = false
            itemView.routineExercisesRV.adapter = RoutineExerciseListAdapter(routine.exercises, true)
        }

        private fun setWeekdays(weekdays: RealmList<DayOfWeekRealm>?) {
            if (weekdays == null)
                return
            for (day in weekdays) {
                val accent = ResourcesCompat.getColor(itemView.resources, R.color.colorAccent, null)

                when {
                    day.enum == DayOfWeek.MONDAY -> {
                        itemView.routineMonday.setTextColor(accent)
                        itemView.routineMonday.setTypeface(null, Typeface.BOLD)
                    }
                    day.enum == DayOfWeek.TUESDAY -> {
                        itemView.routineTuesday.setTextColor(accent)
                        itemView.routineTuesday.setTypeface(null, Typeface.BOLD)
                    }
                    day.enum == DayOfWeek.WEDNESDAY -> {
                        itemView.routineWednesday.setTextColor(accent)
                        itemView.routineWednesday.setTypeface(null, Typeface.BOLD)
                    }
                    day.enum == DayOfWeek.THURSDAY -> {
                        itemView.routineThursday.setTextColor(accent)
                        itemView.routineThursday.setTypeface(null, Typeface.BOLD)
                    }
                    day.enum == DayOfWeek.FRIDAY -> {
                        itemView.routineFriday.setTextColor(accent)
                        itemView.routineFriday.setTypeface(null, Typeface.BOLD)
                    }
                    day.enum == DayOfWeek.SATURDAY -> {
                        itemView.routineSaturday.setTextColor(accent)
                        itemView.routineSaturday.setTypeface(null, Typeface.BOLD)
                    }
                    day.enum == DayOfWeek.SUNDAY -> {
                        itemView.routineSunday.setTextColor(accent)
                        itemView.routineSunday.setTypeface(null, Typeface.BOLD)
                    }
                }
            }
        }

        private fun itemClicked(v: View) {
            val intent = Intent(v.context, WorkoutActivity::class.java)
            val selectedKey = mData!![adapterPosition].idKey
            intent.putExtra(GymStatStringConstants.SELECTED_ROUTINE, selectedKey)
            v.context.startActivity(intent)
        }

        private fun buttonClicked(v: View) {
            Toast.makeText(v.context, "This button start or stop the workout.",
                    Toast.LENGTH_LONG).show()
        }
    }
}