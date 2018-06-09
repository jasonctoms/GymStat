package com.jorbital.gymstat.data

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class ExerciseEntry : RealmObject() {
    @PrimaryKey
    var idKey: String? = null
    var date: Date? = null
    var setNumber: Int = 0
    var weight: Double = 0.toDouble()
    var unit: WeightUnitRealm? = null
    var numberOfReps: Int = 0
    var isBestSet: Boolean = false
}
