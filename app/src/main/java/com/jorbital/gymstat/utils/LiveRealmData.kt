package com.jorbital.gymstat.utils

import android.arch.lifecycle.LiveData

import io.realm.RealmChangeListener
import io.realm.RealmObject
import io.realm.RealmResults

/**
 * This is a wrapper for the RealmResults to expose them as Lifecycle aware LiveData.
 */

class LiveRealmData<T : RealmObject>(var results: RealmResults<T>) : LiveData<RealmResults<T>>() {
    private val listener = RealmChangeListener<RealmResults<T>> { results -> value = results }

    override fun onActive() {
        results.addChangeListener(listener)
    }

    override fun onInactive() {
        results.removeChangeListener(listener)
    }
}
