package com.jorbital.gymstat.data

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Exercise : RealmObject() {
    @PrimaryKey
    var idKey: String? = null
    var exerciseType: ExerciseObject? = null
    var numberOfSets: Int = 0
    var exerciseEntries: RealmList<ExerciseEntry> = RealmList()
    var connectedRoutine: String? = null
}
