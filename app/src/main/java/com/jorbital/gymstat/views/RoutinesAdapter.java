package com.jorbital.gymstat.views;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jorbital.gymstat.GymStatStringConstants;
import com.jorbital.gymstat.R;
import com.jorbital.gymstat.data.Routine;
import com.jorbital.gymstat.utils.DayOfWeekRealm;

import io.realm.OrderedRealmCollection;
import io.realm.RealmList;
import io.realm.RealmRecyclerViewAdapter;

public class RoutinesAdapter extends RealmRecyclerViewAdapter<Routine, RoutinesAdapter.RoutineViewHolder>
{
    private OrderedRealmCollection<Routine> mData;

    RoutinesAdapter(@Nullable OrderedRealmCollection<Routine> data, boolean autoUpdate)
    {
        super(data, autoUpdate);
        mData = data;
    }

    @Override
    public RoutineViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.routines_list_item, parent, false);
        return new RoutineViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RoutineViewHolder holder, int position)
    {
        Routine routine = getItem(position);
        holder.bind(routine);
    }

    @Override
    public int getItemCount()
    {
        return mData.size();
    }

    public class RoutineViewHolder extends RecyclerView.ViewHolder
    {

        public RoutineViewHolder(View itemView)
        {
            super(itemView);
        }

        void bind(Routine item)
        {
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

        private void setWeekdays(RealmList<DayOfWeekRealm> weekdays)
        {
            for(DayOfWeekRealm day : weekdays)
            {
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

        public void itemClicked(View v)
        {
            Intent intent = new Intent(v.getContext(), WorkoutActivity.class);
            String selectedKey = mData.get(getAdapterPosition()).getIdKey();
            intent.putExtra(GymStatStringConstants.SELECTED_ROUTINE, selectedKey);
            v.getContext().startActivity(intent);
        }

        public void buttonClicked(View v)
        {
            Toast.makeText(v.getContext(), "This button start or stop the workout.",
                    Toast.LENGTH_LONG).show();
        }
    }
}
