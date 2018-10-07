package com.jorbital.gymstat.views;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.jorbital.gymstat.GymStatStringConstants;
import com.jorbital.gymstat.R;
import com.jorbital.gymstat.utils.BaseActivityWithNavDrawer;
import com.jorbital.gymstat.viewmodels.WorkoutViewModel;

public class WorkoutActivity extends BaseActivityWithNavDrawer
{
    private WorkoutViewModel vm;

    private String mSelectedRoutineKey;

    RecyclerView workoutRv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        mSelectedRoutineKey = getIntent().getStringExtra(GymStatStringConstants.SELECTED_ROUTINE);

        super.onCreate(savedInstanceState);

        createViewModel();

        String routineName;
        if (mSelectedRoutineKey != null)
             routineName = vm.getSelectedRoutine().getName();
        else
            routineName = getString(R.string.workout_free_workout);

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(routineName);

        workoutRv.setHasFixedSize(true);
        workoutRv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void setLayout()
    {
        setContentView(R.layout.activity_workout);
    }

    protected void createViewModel()
    {
        vm = new WorkoutViewModel();

        //do not init the list if this is a free workout
        if (mSelectedRoutineKey != null)
            vm.Init(mSelectedRoutineKey);
    }

    protected void updateViewFromViewModel()
    {
        if (workoutRv.getAdapter() == null)
        {
            //do not set an adapter if this is the start of a free workout
            if (vm.getWorkoutExercises() != null)
            {
                final WorkoutAdapter adapter = new WorkoutAdapter(vm.getWorkoutExercises(), true, vm);
                workoutRv.setAdapter(adapter);

                workoutRv.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
                {
                    @Override
                    public void onLayoutChange(View v,
                                               int left, int top, int right, int bottom,
                                               int oldLeft, int oldTop, int oldRight, int oldBottom)
                    {
                        if (bottom < oldBottom)
                        {
                            workoutRv.postDelayed(new Runnable()
                            {
                                @Override
                                public void run()
                                {
                                    workoutRv.smoothScrollToPosition(
                                            workoutRv.getAdapter().getItemCount() - 1);
                                }
                            }, 100);
                        }
                    }
                });
            }
        }
        //else
        //update the list
    }

    public void addExercise(View view)
    {
        Intent intent = new Intent(this, ExerciseListActivity.class);
        startActivity(intent);
    }

    public void startWorkout(View view)
    {
        Toast.makeText(WorkoutActivity.this, "This button start or stop the workout.",
                Toast.LENGTH_LONG).show();
    }
}
