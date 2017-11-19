package com.jorbital.gymstat.viewmodels

import android.arch.lifecycle.ViewModel

import com.jorbital.gymstat.data.Routine
import com.jorbital.gymstat.utils.LiveRealmData

import io.realm.Realm

import com.jorbital.gymstat.utils.routineModel

class RoutinesViewModel : ViewModel() {
    private val realm: Realm = Realm.getDefaultInstance()
    var allRoutines: LiveRealmData<Routine>? = null
        private set

    init {
        subscribeToAllRoutines()
    }

    private fun subscribeToAllRoutines() {
        allRoutines = realm.routineModel().findAllRoutines()
    }

    fun noRoutines(): Boolean? {
        var test2 = allRoutines
        var test = allRoutines?.value

        return if (allRoutines!!.value != null)
            allRoutines!!.value!!.isEmpty()
        else
            null
    }

    override fun onCleared() {
        realm.close()
        super.onCleared()
    }
}
