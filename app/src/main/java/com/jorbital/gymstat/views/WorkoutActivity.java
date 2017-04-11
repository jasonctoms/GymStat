package com.jorbital.gymstat.views;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.jorbital.gymstat.GymStatStringConstants;
import com.jorbital.gymstat.R;
import com.jorbital.gymstat.databinding.ActivityWorkoutBinding;
import com.jorbital.gymstat.viewmodels.WorkoutViewModel;

import io.realm.Realm;

public class WorkoutActivity extends AppCompatActivity
{
    private Realm realm;
    private String mSelectedRoutineKey;
    private WorkoutViewModel mViewModel;

    private ActivityWorkoutBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this, R.layout.activity_workout);
        b.setActivity(this);
        realm = Realm.getDefaultInstance();

        mSelectedRoutineKey = getIntent().getStringExtra(GymStatStringConstants.SELECTED_ROUTINE);

        CreateViewModel();
        String routineName = mViewModel.getSelectedRoutine().getName();

        setSupportActionBar(b.toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(routineName);

        b.workoutRv.setHasFixedSize(true);
        b.workoutRv.setAdapter(new WorkoutAdapter(mViewModel.getWorkoutExercises(), true));
        b.workoutRv.setLayoutManager(new LinearLayoutManager(this));
    }

    private void CreateViewModel()
    {
        mViewModel = new WorkoutViewModel(realm);
        mViewModel.Init(mSelectedRoutineKey);
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
