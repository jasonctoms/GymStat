package com.jorbital.gymstat.views;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.jorbital.gymstat.R;
import com.jorbital.gymstat.databinding.ActivityRoutinesBinding;

public class RoutinesActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{
    ActivityRoutinesBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this, R.layout.activity_routines);

        setSupportActionBar(b.toolbar);

        b.fabMenuFreeWorkout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startFreeWorkout();
            }
        });

        b.fabMenuNewRoutine.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                addRoutine();
            }
        });

        b.addRoutineButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                addRoutine();
            }
        });

        b.freeWorkoutButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startFreeWorkout();
            }
        });

        b.plateCalcButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                plateCalculator();
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, b.drawerLayout, b.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        b.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        b.navView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed()
    {
        if (b.drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            b.drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera)
        {
            // Handle the camera action
        }
        else if (id == R.id.nav_gallery)
        {

        }
        else if (id == R.id.nav_slideshow)
        {

        }
        else if (id == R.id.nav_settings)
        {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_share)
        {

        }
        else if (id == R.id.nav_send)
        {

        }

        b.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void addRoutine()
    {
        Intent intent = new Intent(this, EditRoutineActivity.class);
        startActivity(intent);
    }

    public void startFreeWorkout()
    {
        Intent intent = new Intent(this, WorkoutActivity.class);
        startActivity(intent);
    }

    public void plateCalculator()
    {
        new PlateCalcDialog(this).show();
    }
}
