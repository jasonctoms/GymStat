@file:JvmName("RealmUtils")
package com.jorbital.gymstat.utils

import com.jorbital.gymstat.data.RoutineDao
import io.realm.Realm
import io.realm.RealmObject
import io.realm.RealmResults

/**
 * Created by jasontoms on 19/11/2017.
 */

fun Realm.routineModel(): RoutineDao = RoutineDao(this)

fun <T: RealmObject> RealmResults<T>.asLiveData() = LiveRealmData<T>(this)