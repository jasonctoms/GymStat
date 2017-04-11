package com.jorbital.gymstat.views;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jorbital.gymstat.GymStatStringConstants;
import com.jorbital.gymstat.data.Routine;
import com.jorbital.gymstat.databinding.RoutinesListItemBinding;

import io.realm.OrderedRealmCollection;
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
        RoutinesListItemBinding b = RoutinesListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new RoutineViewHolder(b);
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
            Intent intent = new Intent(v.getContext(), WorkoutActivity.class);
            String selectedKey = mData.get(getAdapterPosition()).getIdKey();
            intent.putExtra(GymStatStringConstants.SELECTED_ROUTINE, selectedKey);
            v.getContext().startActivity(intent);
        }
    }
}
