package com.jorbital.gymstat.views;

import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jorbital.gymstat.R;
import com.jorbital.gymstat.data.ExerciseObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

class ExerciseListAdapter extends RealmRecyclerViewAdapter<ExerciseObject, ExerciseListAdapter.ExerciseViewHolder>
{

    OrderedRealmCollection<ExerciseObject> mData;

    ExerciseListAdapter(@Nullable OrderedRealmCollection<ExerciseObject> data, boolean autoUpdate)
    {
        super(data, autoUpdate);
        mData = data;
    }

    @Override
    public ExerciseViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.exercise_list_item, parent, false);

        return new ExerciseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExerciseViewHolder holder, int position)
    {
        ExerciseObject exercise = getItem(position);
        holder.exerciseName.setText(exercise.getName());
    }

    @Override
    public int getItemCount()
    {
        return mData.size();
    }

    static class ExerciseViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.exercise_name)
        TextView exerciseName;

        ExerciseViewHolder(View v)
        {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
