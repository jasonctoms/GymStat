package com.jorbital.gymstat.views;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jorbital.gymstat.R;
import com.jorbital.gymstat.data.Exercise;

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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_routine_list_item, parent, false);
        return new EditRoutineViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EditRoutineViewHolder holder, int position)
    {
        Exercise exercise = getItem(position);
    }

    @Override
    public int getItemCount()
    {
        return mData.size();
    }

    public class EditRoutineViewHolder extends RecyclerView.ViewHolder
    {

        public EditRoutineViewHolder(View itemView)
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