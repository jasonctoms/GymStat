package com.jorbital.gymstat.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.jorbital.gymstat.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WorkoutActivity extends AppCompatActivity
{
    @BindView(R.id.workout_fab) FloatingActionButton fab;
    @BindView(R.id.add_exercise_button) Button addExerciseButton;
    @BindView(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(WorkoutActivity.this, "This button start or stop the workout.",
                        Toast.LENGTH_LONG).show();
            }
        });

        addExerciseButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                addExercise();
            }
        });
    }

    public void addExercise()
    {
        Intent intent = new Intent(this, ExerciseListActivity.class);
        startActivity(intent);
    }
}
