package com.jorbital.gymstat.views

import android.content.Intent
import android.support.v7.widget.RecyclerView
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

class RoutinesAdapter internal constructor(private val mData: OrderedRealmCollection<Routine>?, autoUpdate: Boolean) : RealmRecyclerViewAdapter<Routine, RoutinesAdapter.RoutineViewHolder>(mData, autoUpdate) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoutineViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.routines_list_item, parent, false)
        return RoutineViewHolder(v)
    }

    override fun onBindViewHolder(holder: RoutineViewHolder, position: Int) {
        val routine = getItem(position)
        holder.bind(routine)
    }

    override fun getItemCount(): Int = mData!!.size

    inner class RoutineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal fun bind(item: Routine?) {
            //            b.routineName.setText(item.getName());
            //
            //            LocalDateTime now = LocalDateTime.now();
            //            LocalDateTime then = LocalDateTime.parse(item.getLastCompletedDate());
            //            int days = (int) Duration.between(then, now).toDays();
            //            b.lastPerformed.setText(String.format(itemView.getContext().getString(R.string.routines_last_performed), days));
            //
            //            RealmList<DayOfWeekRealm> weekdays = item.getDays();
            //            setWeekdays(weekdays);
            //
            //            b.routineExercisesRV.setHasFixedSize(true);
            //            b.routineExercisesRV.setLayoutManager(new LinearLayoutManager(itemView.getContext(),
            //                    LinearLayoutManager.VERTICAL, false));
            //            b.routineExercisesRV.setNestedScrollingEnabled(false);
            //            b.routineExercisesRV.setAdapter(new RoutineExerciseListAdapter(item.getExercises(), true));
            //
            //            b.executePendingBindings();
        }

        private fun setWeekdays(weekdays: RealmList<DayOfWeekRealm>) {
            for (day in weekdays) {
                //                int accent = ResourcesCompat.getColor(itemView.getResources(), R.color.colorAccent, null);
                //
                //                if(day.getEnum() == DayOfWeek.MONDAY)
                //                {
                //                    b.routineMonday.setTextColor(accent);
                //                    b.routineMonday.setTypeface(null, Typeface.BOLD);
                //                }
                //                else if(day.getEnum() == DayOfWeek.TUESDAY)
                //                {
                //                    b.routineTuesday.setTextColor(accent);
                //                    b.routineTuesday.setTypeface(null, Typeface.BOLD);
                //                }
                //                else if(day.getEnum() == DayOfWeek.WEDNESDAY)
                //                {
                //                    b.routineWednesday.setTextColor(accent);
                //                    b.routineWednesday.setTypeface(null, Typeface.BOLD);
                //                }
                //                else if(day.getEnum() == DayOfWeek.THURSDAY)
                //                {
                //                    b.routineThursday.setTextColor(accent);
                //                    b.routineThursday.setTypeface(null, Typeface.BOLD);
                //                }
                //                else if(day.getEnum() == DayOfWeek.FRIDAY)
                //                {
                //                    b.routineFriday.setTextColor(accent);
                //                    b.routineFriday.setTypeface(null, Typeface.BOLD);
                //                }
                //                else if(day.getEnum() == DayOfWeek.SATURDAY)
                //                {
                //                    b.routineSaturday.setTextColor(accent);
                //                    b.routineSaturday.setTypeface(null, Typeface.BOLD);
                //                }
                //                else if(day.getEnum() == DayOfWeek.SUNDAY)
                //                {
                //                    b.routineSunday.setTextColor(accent);
                //                    b.routineSunday.setTypeface(null, Typeface.BOLD);
                //                }
            }
        }

        fun itemClicked(v: View) {
            val intent = Intent(v.context, WorkoutActivity::class.java)
            val selectedKey = mData!![adapterPosition].idKey
            intent.putExtra(GymStatStringConstants.SELECTED_ROUTINE, selectedKey)
            v.context.startActivity(intent)
        }

        fun buttonClicked(v: View) {
            Toast.makeText(v.context, "This button start or stop the workout.",
                    Toast.LENGTH_LONG).show()
        }
    }
}
