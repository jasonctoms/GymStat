package com.jorbital.gymstat.views;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.jorbital.gymstat.R;
import com.jorbital.gymstat.databinding.ActivityWorkoutBinding;

public class WorkoutActivity extends AppCompatActivity
{
    ActivityWorkoutBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this, R.layout.activity_workout);
        b.setActivity(this);

        setSupportActionBar(b.toolbar);
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
