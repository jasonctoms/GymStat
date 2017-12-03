package com.jorbital.gymstat.utils

import io.realm.RealmObject
import org.threeten.bp.DayOfWeek

open class DayOfWeekRealm : RealmObject() {
    private var dayOfWeek: String = ""

    var enum: DayOfWeek
        get() = DayOfWeek.valueOf(dayOfWeek)
        set(`val`) {
            this.dayOfWeek = `val`.toString()
        }
}
