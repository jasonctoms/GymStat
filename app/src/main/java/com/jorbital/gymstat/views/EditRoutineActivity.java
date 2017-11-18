package com.jorbital.gymstat.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jorbital.gymstat.GymStatStringConstants;
import com.jorbital.gymstat.R;
import com.jorbital.gymstat.utils.BaseActivityWithNavDrawer;
import com.jorbital.gymstat.viewmodels.EditRoutineViewModel;

public class EditRoutineActivity extends BaseActivityWithNavDrawer
{
    private EditRoutineViewModel vm;

    private String mSelectedRoutineKey;

    RecyclerView editRoutineRV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        mSelectedRoutineKey = getIntent().getStringExtra(GymStatStringConstants.SELECTED_ROUTINE);

        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setLayout()
    {
        setContentView(R.layout.activity_edit_routine);
    }

    @Override
    protected void createViewModel()
    {
        vm = new EditRoutineViewModel(realm);

        //do not init the list if user is making a new routine
        if (mSelectedRoutineKey != null)
            vm.Init(mSelectedRoutineKey);
    }

    @Override
    protected void updateViewFromViewModel()
    {
        if (editRoutineRV.getAdapter() == null)
        {
            //do not set an adapter if user is making a new routine
            if (vm.getRoutineExercises() != null)
                editRoutineRV.setAdapter(new EditRoutineAdapter(vm.getRoutineExercises(), true));
        }
        //else
        //update the list
    }

    public void addExercise(View view)
    {
        Intent intent = new Intent(this, ExerciseListActivity.class);
        startActivity(intent);
    }
}
