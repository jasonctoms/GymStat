package com.apps.straightface.gymstat.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.apps.straightface.gymstat.R;
import com.github.clans.fab.FloatingActionButton;

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
                Toast.makeText(WorkoutActivity.this, "This button start the exercise picker.",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
