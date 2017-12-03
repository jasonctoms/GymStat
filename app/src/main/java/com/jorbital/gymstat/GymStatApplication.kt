package com.jorbital.gymstat

import android.app.Application

import com.jakewharton.threetenabp.AndroidThreeTen
import com.jorbital.gymstat.data.DefaultRealmObjects

import io.realm.Realm
import io.realm.RealmConfiguration

class GymStatApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        AndroidThreeTen.init(this)
        Realm.init(this)
        if (BuildConfig.DEBUG) {
            val config = RealmConfiguration.Builder()
                    .deleteRealmIfMigrationNeeded()
                    .build()
            Realm.setDefaultConfiguration(config)
        }

        //TODO: check to make sure this hasn't been done yet
        val defaultRealmObjects = DefaultRealmObjects()
        defaultRealmObjects.initializeDefaultRealmObjects(this)
    }
}
