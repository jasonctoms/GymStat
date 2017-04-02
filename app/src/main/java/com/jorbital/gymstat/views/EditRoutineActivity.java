package com.jorbital.gymstat.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.jorbital.gymstat.R;
import com.github.clans.fab.FloatingActionButton;

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
                Toast.makeText(EditRoutineActivity.this, "This button will open the exercise picker.",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
