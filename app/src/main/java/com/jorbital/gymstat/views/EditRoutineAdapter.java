package com.jorbital.gymstat.views;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jorbital.gymstat.data.Exercise;
import com.jorbital.gymstat.databinding.EditRoutineListItemBinding;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class EditRoutineAdapter extends RealmRecyclerViewAdapter<Exercise, EditRoutineAdapter.EditRoutineViewHolder>
{
    private OrderedRealmCollection<Exercise> mData;

    EditRoutineAdapter(@Nullable OrderedRealmCollection<Exercise> data, boolean autoUpdate)
    {
        super(data, autoUpdate);
        mData = data;
    }

    @Override
    public EditRoutineViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        EditRoutineListItemBinding b = EditRoutineListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new EditRoutineViewHolder(b);
    }

    @Override
    public void onBindViewHolder(EditRoutineViewHolder holder, int position)
    {
        Exercise exercise = getItem(position);
        holder.bind(exercise);
    }

    @Override
    public int getItemCount()
    {
        return mData.size();
    }

    public class EditRoutineViewHolder extends RecyclerView.ViewHolder
    {
        private final EditRoutineListItemBinding b;

        EditRoutineViewHolder(EditRoutineListItemBinding binding)
        {
            super(binding.getRoot());
            this.b = binding;
            b.setVh(this);
        }

        void bind(Exercise item)
        {
            b.exerciseName.setText(item.getExerciseType().getName());
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