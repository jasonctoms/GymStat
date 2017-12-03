package com.jorbital.gymstat;

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;
import com.jorbital.gymstat.data.DefaultRealmObjects;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class GymStatApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        AndroidThreeTen.init(this);
        Realm.init(this);
        if (BuildConfig.DEBUG)
        {
            RealmConfiguration config = new RealmConfiguration
                    .Builder()
                    .deleteRealmIfMigrationNeeded()
                    .build();
            Realm.setDefaultConfiguration(config);
        }

        //TODO: check to make sure this hasn't been done yet
        DefaultRealmObjects defaultRealmObjects = new DefaultRealmObjects();
        defaultRealmObjects.initializeDefaultRealmObjects(this);
    }
}
