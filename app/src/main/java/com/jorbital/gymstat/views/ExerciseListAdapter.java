package com.jorbital.gymstat.views;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jorbital.gymstat.data.ExerciseObject;
import com.jorbital.gymstat.databinding.ExerciseListItemBinding;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

class ExerciseListAdapter extends RealmRecyclerViewAdapter<ExerciseObject, ExerciseViewHolder>
{

    private OrderedRealmCollection<ExerciseObject> mData;

    ExerciseListAdapter(@Nullable OrderedRealmCollection<ExerciseObject> data, boolean autoUpdate)
    {
        super(data, autoUpdate);
        mData = data;
    }

    @Override
    public ExerciseViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        ExerciseListItemBinding b = ExerciseListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ExerciseViewHolder(b);
    }

    @Override
    public void onBindViewHolder(ExerciseViewHolder holder, int position)
    {
        ExerciseObject exercise = getItem(position);
        holder.bind(exercise);
    }

    @Override
    public int getItemCount()
    {
        return mData.size();
    }
}
