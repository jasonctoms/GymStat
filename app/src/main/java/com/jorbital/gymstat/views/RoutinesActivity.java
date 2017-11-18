package com.jorbital.gymstat.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jorbital.gymstat.R;
import com.jorbital.gymstat.utils.BaseActivityWithNavDrawer;
import com.jorbital.gymstat.viewmodels.RoutinesViewModel;

public class RoutinesActivity extends BaseActivityWithNavDrawer
{
    private RoutinesViewModel vm;

    RecyclerView routinesRv;
    ConstraintLayout noRoutinesLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if (vm.getAllRoutines().isEmpty())
            noRoutinesLayout.setVisibility(View.VISIBLE);

        routinesRv.setHasFixedSize(true);

        routinesRv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void setLayout()
    {
        setContentView(R.layout.activity_routines);
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
        if (routinesRv.getAdapter() == null)
            routinesRv.setAdapter(new RoutinesAdapter(vm.getAllRoutines(), true));
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
