package com.jorbital.gymstat.views;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jorbital.gymstat.R;
import com.jorbital.gymstat.databinding.ActivityRoutinesBinding;
import com.jorbital.gymstat.utils.BaseActivityWithNavDrawer;
import com.jorbital.gymstat.viewmodels.RoutinesViewModel;

public class RoutinesActivity extends BaseActivityWithNavDrawer
{
    private ActivityRoutinesBinding b;
    private RoutinesViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if (vm.getAllRoutines().isEmpty())
            b.noRoutinesLayout.setVisibility(View.VISIBLE);

        b.routinesRv.setHasFixedSize(true);

        b.routinesRv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void setLayout()
    {
        b = DataBindingUtil.setContentView(this, R.layout.activity_routines);
        b.setActivity(this);
    }

    @Override
    protected void createViewModel()
    {
        vm = new RoutinesViewModel(realm);
        vm.makeListOfRoutines();
    }

    @Override
    protected void updateViewFromViewModel()
    {
        if (b.routinesRv.getAdapter() == null)
            b.routinesRv.setAdapter(new RoutinesAdapter(vm.getAllRoutines(), true));
        //else
           //update the list
    }

    public void addRoutine(View view)
    {
        Intent intent = new Intent(this, EditRoutineActivity.class);
        startActivity(intent);
    }

    public void startFreeWorkout(View view)
    {
        Intent intent = new Intent(this, WorkoutActivity.class);
        startActivity(intent);
    }

    public void plateCalculator(View view)
    {
        new PlateCalcDialog(this).show();
    }
}
