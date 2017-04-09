package com.jorbital.gymstat.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.jorbital.gymstat.data.Routine;
import com.jorbital.gymstat.databinding.RoutinesListItemBinding;

public class RoutineViewHolder extends RecyclerView.ViewHolder
{
    private final RoutinesListItemBinding b;

    RoutineViewHolder(RoutinesListItemBinding binding)
    {
        super(binding.getRoot());
        this.b = binding;
        b.setVh(this);
    }

    void bind(Routine item)
    {
        b.routineName.setText(item.getName());
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
