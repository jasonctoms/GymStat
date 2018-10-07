package com.jorbital.gymstat.views;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jorbital.gymstat.R;
import com.jorbital.gymstat.data.ExerciseObject;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class ExerciseListAdapter extends RealmRecyclerViewAdapter<ExerciseObject, ExerciseListAdapter.ExerciseViewHolder>
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercise_list_item, parent, false);
        return new ExerciseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExerciseViewHolder holder, int position)
    {
        ExerciseObject exercise = getItem(position);
    }

    @Override
    public int getItemCount()
    {
        return mData.size();
    }

    public class ExerciseViewHolder extends RecyclerView.ViewHolder
    {

        public ExerciseViewHolder(View itemView)
        {
            super(itemView);
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
