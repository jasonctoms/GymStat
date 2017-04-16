package com.jorbital.gymstat.utils;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.jorbital.gymstat.R;
import com.jorbital.gymstat.views.SettingsActivity;

import io.realm.Realm;

/* this activity contains the navigation drawer and the realm initiation/closing
 * so this does not need to be done in every activity.  It also provides the method to create
 * a ViewModel that must be overridden
 */

public abstract class BaseActivityWithNavDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    DrawerLayout drawerLayout;
    NavigationView navView;
    Toolbar toolbar;

    protected Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setLayout();

        /* set the realm instance for the activity and then create
        the viewmodel from the parameters obtained from intents */
        realm = Realm.getDefaultInstance();
        createViewModel();
        updateViewFromViewModel();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navView = (NavigationView) findViewById(R.id.navView);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(this);
    }

    /* method that must be overridden that sets the content view of
     * the selected activity (activity must have navigation view and
     * drawer layouts in its own xml layout file) */
    protected abstract void setLayout();

    /* method that must be overridden that creates the viewmodel
     * using a realm instance and any other parameters necessary */
    protected abstract void createViewModel();

    /* method that must be overridden that uses data from the viewmodel
     * to update the view */
    protected abstract void updateViewFromViewModel();

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_settings)
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

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed()
    {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        realm.close();
    }
}
