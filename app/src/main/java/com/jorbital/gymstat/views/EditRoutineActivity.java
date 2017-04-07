package com.jorbital.gymstat.views;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jorbital.gymstat.R;
import com.jorbital.gymstat.databinding.ActivityEditRoutineBinding;

import butterknife.ButterKnife;

public class EditRoutineActivity extends AppCompatActivity
{
    ActivityEditRoutineBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this, R.layout.activity_edit_routine);
        ButterKnife.bind(this);

        b.addRoutineFab.setOnClickListener(new View.OnClickListener()
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
