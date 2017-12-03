@file:JvmName("RealmUtils")
package com.jorbital.gymstat.utils

import com.jorbital.gymstat.data.RoutineDao
import io.realm.Realm
import io.realm.RealmObject
import io.realm.RealmResults

/**
 * Kotlin extension methods to handle the daos
 */

fun Realm.routineModel(): RoutineDao = RoutineDao(this)

fun <T: RealmObject> RealmResults<T>.asLiveData() = LiveRealmData(this)