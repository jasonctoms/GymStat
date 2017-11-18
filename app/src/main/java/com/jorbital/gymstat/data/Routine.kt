package com.jorbital.gymstat.data

import com.jorbital.gymstat.utils.DayOfWeekRealm

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Routine : RealmObject() {
    @PrimaryKey
    var idKey: String? = null
    var name: String? = null
    var lastCompletedDate: String? = null
    var days: RealmList<DayOfWeekRealm>? = null
    var exercises: RealmList<Exercise>? = null
}
