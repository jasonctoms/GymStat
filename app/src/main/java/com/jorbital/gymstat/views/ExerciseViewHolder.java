package com.jorbital.gymstat.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.jorbital.gymstat.data.ExerciseObject;
import com.jorbital.gymstat.databinding.ExerciseListItemBinding;


public class ExerciseViewHolder extends RecyclerView.ViewHolder
{
    private final ExerciseListItemBinding b;

    ExerciseViewHolder(ExerciseListItemBinding binding)
    {
        super(binding.getRoot());
        this.b = binding;
        b.setVh(this);
    }

    void bind(ExerciseObject item)
    {
        b.exerciseName.setText(item.getName());
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
