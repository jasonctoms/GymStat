package com.apps.straightface.gymstat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;

public class EditRoutineActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_routine);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_routine_fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(EditRoutineActivity.this, "This button will open the exercise picker.",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
