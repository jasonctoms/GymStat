package com.jorbital.gymstat.views;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jorbital.gymstat.data.Routine;
import com.jorbital.gymstat.databinding.RoutinesListItemBinding;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

class RoutinesAdapter extends RealmRecyclerViewAdapter<Routine, RoutineViewHolder>
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
}
