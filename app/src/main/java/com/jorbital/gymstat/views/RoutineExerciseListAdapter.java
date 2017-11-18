package com.jorbital.gymstat.views;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jorbital.gymstat.R;
import com.jorbital.gymstat.data.Exercise;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class RoutineExerciseListAdapter extends RealmRecyclerViewAdapter<Exercise, RoutineExerciseListAdapter.RoutineExerciseViewHolder>
{
    private OrderedRealmCollection<Exercise> mData;

    RoutineExerciseListAdapter(@Nullable OrderedRealmCollection<Exercise> data, boolean autoUpdate)
    {
        super(data, autoUpdate);
        mData = data;
    }

    @Override
    public RoutineExerciseViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.routine_exercise_list_item, parent, false);
        return new RoutineExerciseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RoutineExerciseViewHolder holder, int position)
    {
        Exercise exercise = getItem(position);
    }

    @Override
    public int getItemCount()
    {
        return mData.size();
    }

    public class RoutineExerciseViewHolder extends RecyclerView.ViewHolder
    {

        public RoutineExerciseViewHolder(View itemView)
        {
            super(itemView);
        }
    }
}
