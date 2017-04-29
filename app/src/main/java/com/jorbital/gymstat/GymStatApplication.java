package com.jorbital.gymstat;

import android.app.Application;

import com.jorbital.gymstat.data.DefaultRealmObjects;
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
        DefaultRealmObjects defaultRealmObjects = new DefaultRealmObjects();
        defaultRealmObjects.initializeDefaultRealmObjects(this);
    }
}
