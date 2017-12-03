package com.jorbital.gymstat.data

import com.jorbital.gymstat.utils.LiveRealmData
import com.jorbital.gymstat.utils.asLiveData
import io.realm.Realm

/**
 * This class exists to keep database queries separate from other code
 */

class RoutineDao(private val realm: Realm) {

    fun findAllRoutines(): LiveRealmData<Routine> {
        return realm.where(Routine::class.java).findAll().asLiveData()
    }
}
