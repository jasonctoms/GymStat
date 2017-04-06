package com.jorbital.gymstat.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.github.clans.fab.FloatingActionButton;
import com.jorbital.gymstat.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RoutinesActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{
    @BindView(R.id.fab_menu_item1) FloatingActionButton fabItem1;
    @BindView(R.id.fab_menu_item2) FloatingActionButton fabItem2;
    @BindView(R.id.add_routine_button) Button addRoutineButton;
    @BindView(R.id.free_workout_button) Button startFreeWorkoutButton;
    @BindView(R.id.plate_calc_button) Button plateCalcButton;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.drawer_layout) DrawerLayout drawer;
    @BindView(R.id.nav_view) NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routines);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        fabItem1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startFreeWorkout();
            }
        });

        fabItem2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                addRoutine();
            }
        });

        addRoutineButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                addRoutine();
            }
        });

        startFreeWorkoutButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startFreeWorkout();
            }
        });

        plateCalcButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                plateCalculator();
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed()
    {
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
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

        drawer.closeDrawer(GravityCompat.START);
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