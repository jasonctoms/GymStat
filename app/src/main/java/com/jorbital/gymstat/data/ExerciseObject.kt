package com.jorbital.gymstat.data

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class ExerciseObject : RealmObject() {
    @PrimaryKey
    var idKey: String? = null
    var name: String? = null
    var muscleGroup: RealmList<MuscleGroupRealm>? = null
    var imagePath: String? = null
}
