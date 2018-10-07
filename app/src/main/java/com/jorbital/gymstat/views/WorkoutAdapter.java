package com.jorbital.gymstat.views;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jorbital.gymstat.R;
import com.jorbital.gymstat.data.Exercise;
import com.jorbital.gymstat.viewmodels.WorkoutViewModel;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class WorkoutAdapter extends RealmRecyclerViewAdapter<Exercise, WorkoutAdapter.WorkoutViewHolder>
{
    private OrderedRealmCollection<Exercise> mData;
    private WorkoutViewModel mViewModel;

    WorkoutAdapter(@Nullable OrderedRealmCollection<Exercise> data, boolean autoUpdate, WorkoutViewModel viewModel)
    {
        super(data, autoUpdate);
        mData = data;
        mViewModel = viewModel;
    }

    @Override
    public WorkoutViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_list_item, parent, false);
        return new WorkoutViewHolder(v);
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
        public WorkoutViewHolder(View itemView)
        {
            super(itemView);
        }

        void bind(Exercise item)
        {
//            b.workoutName.setText(item.getExerciseType().getName());
//            String path = item.getExerciseType().getImagePath();
//            Glide.with(itemView.getContext()).load(Uri.parse(path)).into(b.workoutImage);
//            b.numberOfSets.setText(String.valueOf(item.getNumberOfSets()));
//            b.executePendingBindings();
        }

        public void itemClicked(View v)
        {
            Toast.makeText(v.getContext(), "Single Click on position: " + getAdapterPosition(),
                    Toast.LENGTH_SHORT).show();
        }

        public void decrementClicked(View v)
        {
            Exercise selectedItem = getItem(getAdapterPosition());
            //noinspection ConstantConditions -- getIdKey cannot be null but the compiler doesn't know that
            //b.getVm().changeSetsForExercise(selectedItem.getIdKey(), selectedItem.getNumberOfSets() - 1);
        }

        public void incrementClicked(View v)
        {
            Exercise selectedItem = getItem(getAdapterPosition());
            //noinspection ConstantConditions -- getIdKey cannot be null but the compiler doesn't know that
            //b.getVm().changeSetsForExercise(selectedItem.getIdKey(), selectedItem.getNumberOfSets() + 1);
        }
    }
}
