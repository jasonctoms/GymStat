package com.jorbital.gymstat.views;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.jorbital.gymstat.GymStatStringConstants;
import com.jorbital.gymstat.R;
import com.jorbital.gymstat.databinding.ActivityEditRoutineBinding;
import com.jorbital.gymstat.utils.BaseActivityWithNavDrawer;
import com.jorbital.gymstat.viewmodels.EditRoutineViewModel;

public class EditRoutineActivity extends BaseActivityWithNavDrawer
{
    private ActivityEditRoutineBinding b;
    private EditRoutineViewModel vm;

    private String mSelectedRoutineKey;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        mSelectedRoutineKey = getIntent().getStringExtra(GymStatStringConstants.SELECTED_ROUTINE);

        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setLayout()
    {
        b = DataBindingUtil.setContentView(this, R.layout.activity_edit_routine);
        b.setActivity(this);
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
        if (b.editRoutineRV.getAdapter() == null)
        {
            //do not set an adapter if user is making a new routine
            if (vm.getRoutineExercises() != null)
                b.editRoutineRV.setAdapter(new EditRoutineAdapter(vm.getRoutineExercises(), true));
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
