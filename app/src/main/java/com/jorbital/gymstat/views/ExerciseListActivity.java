package com.jorbital.gymstat.views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.jorbital.gymstat.R;
import com.jorbital.gymstat.databinding.ActivityExerciseListBinding;
import com.jorbital.gymstat.utils.BaseActivityWithNavDrawer;
import com.jorbital.gymstat.viewmodels.ExerciseListViewModel;

public class ExerciseListActivity extends BaseActivityWithNavDrawer
{
    private ActivityExerciseListBinding b;
    private ExerciseListViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        b.exerciseRv.setHasFixedSize(true);
        b.exerciseRv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void setLayout()
    {
        b = DataBindingUtil.setContentView(this, R.layout.activity_exercise_list);
        b.setActivity(this);
    }

    @Override
    protected void createViewModel()
    {
        vm = new ExerciseListViewModel(realm);
        vm.makeListOfExercises();
    }

    @Override
    protected void updateViewFromViewModel()
    {
        if (b.exerciseRv.getAdapter() == null)
            b.exerciseRv.setAdapter(new ExerciseListAdapter(vm.getAllExercises(), true));
        //else
           //update list
    }

    public void fabClicked(View view)
    {
        Toast.makeText(this, "This will let the user add a new exercise to the database, or save the selection if multiple items are selected.", Toast.LENGTH_LONG)
                .show();
    }
}
