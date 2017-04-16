package com.jorbital.gymstat.views;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jorbital.gymstat.R;
import com.jorbital.gymstat.data.Exercise;
import com.jorbital.gymstat.databinding.RoutineExerciseListItemBinding;

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
        RoutineExerciseListItemBinding b = RoutineExerciseListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new RoutineExerciseViewHolder(b);
    }

    @Override
    public void onBindViewHolder(RoutineExerciseViewHolder holder, int position)
    {
        Exercise exercise = getItem(position);
        holder.bind(exercise);
    }

    @Override
    public int getItemCount()
    {
        return mData.size();
    }

    public class RoutineExerciseViewHolder extends RecyclerView.ViewHolder
    {
        private final RoutineExerciseListItemBinding b;

        RoutineExerciseViewHolder(RoutineExerciseListItemBinding binding)
        {
            super(binding.getRoot());
            this.b = binding;
            b.setVh(this);
        }

        void bind(Exercise item)
        {
            b.routineExerciseName.setText(item.getExerciseType().getName() + " ");
            int sets = item.getNumberOfSets();
            b.numberOfSets.setText(String.format(itemView.getContext().getString(R.string.routines_number_sets), sets));
            b.executePendingBindings();
        }
    }
}
