package com.jorbital.gymstat.views;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.jorbital.gymstat.R;
import com.jorbital.gymstat.utils.BaseActivityWithNavDrawer;
import com.jorbital.gymstat.viewmodels.ExerciseListViewModel;

public class ExerciseListActivity extends BaseActivityWithNavDrawer
{
    private ExerciseListViewModel vm;

    RecyclerView exerciseRv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        exerciseRv.setHasFixedSize(true);
        exerciseRv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void setLayout()
    {
        setContentView(R.layout.activity_exercise_list);
    }

    protected void createViewModel()
    {
        vm = new ExerciseListViewModel();
        vm.makeListOfExercises();
    }

    protected void updateViewFromViewModel()
    {
        if (exerciseRv.getAdapter() == null)
            exerciseRv.setAdapter(new ExerciseListAdapter(vm.getAllExercises(), true));
        //else
           //update list
    }

    public void fabClicked(View view)
    {
        Toast.makeText(this, "This will let the user add a new exercise to the database, or save the selection if multiple items are selected.", Toast.LENGTH_LONG)
                .show();
    }
}
