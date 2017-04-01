package com.apps.straightface.gymstat;

import android.app.Application;

import com.apps.straightface.gymstat.Data.DefaultExercises;
import com.jakewharton.threetenabp.AndroidThreeTen;

import io.realm.Realm;

public class GymStatApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        AndroidThreeTen.init(this);
        Realm.init(this);

        //TODO: check to make sure this hasn't been done yet
        DefaultExercises defaultExercises = new DefaultExercises();
        defaultExercises.initializeDefaultExercises(this);
    }
}
