package com.jorbital.gymstat.views;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jorbital.gymstat.data.Exercise;
import com.jorbital.gymstat.databinding.WorkoutListItemBinding;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class WorkoutAdapter extends RealmRecyclerViewAdapter<Exercise, WorkoutAdapter.WorkoutViewHolder>
{
    private OrderedRealmCollection<Exercise> mData;

    WorkoutAdapter(@Nullable OrderedRealmCollection<Exercise> data, boolean autoUpdate)
    {
        super(data, autoUpdate);
        mData = data;
    }

    @Override
    public WorkoutViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        WorkoutListItemBinding b = WorkoutListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new WorkoutViewHolder(b);
    }

    @Override
    public void onBindViewHolder(WorkoutViewHolder holder, int position)
    {
        Exercise exercise = getItem(position);
        holder.bind(exercise);
    }

    @Override
    public int getItemCount()
    {
        return mData.size();
    }

    public class WorkoutViewHolder extends RecyclerView.ViewHolder
    {
        private final WorkoutListItemBinding b;

        WorkoutViewHolder(WorkoutListItemBinding binding)
        {
            super(binding.getRoot());
            this.b = binding;
            b.setVh(this);
        }

        void bind(Exercise item)
        {
            b.workoutName.setText(item.getExerciseType().getName());
            b.executePendingBindings();
        }

        public void itemClicked(View v)
        {
            Toast.makeText(v.getContext(), "Single Click on position: " + getAdapterPosition(),
                    Toast.LENGTH_SHORT).show();
        }

        public boolean itemLongClicked(View v)
        {
            Toast.makeText(v.getContext(), "Long Click on position: " + getAdapterPosition(),
                    Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}
