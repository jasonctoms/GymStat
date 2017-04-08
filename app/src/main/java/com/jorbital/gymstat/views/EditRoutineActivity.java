package com.jorbital.gymstat.views;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jorbital.gymstat.R;
import com.jorbital.gymstat.databinding.ActivityEditRoutineBinding;

public class EditRoutineActivity extends AppCompatActivity
{
    ActivityEditRoutineBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this, R.layout.activity_edit_routine);
        b.setActivity(this);
    }

    public void addExercise(View view)
    {
        Intent intent = new Intent(this, ExerciseListActivity.class);
        startActivity(intent);
    }
}
