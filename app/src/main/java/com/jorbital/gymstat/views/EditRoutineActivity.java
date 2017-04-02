package com.jorbital.gymstat.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.clans.fab.FloatingActionButton;
import com.jorbital.gymstat.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditRoutineActivity extends AppCompatActivity
{
    @BindView(R.id.add_routine_fab) FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_routine);
        ButterKnife.bind(this);

        fab.setOnClickListener(new View.OnClickListener()
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
