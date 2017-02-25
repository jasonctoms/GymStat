package com.apps.straightface.gymstat.Data;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Stats extends RealmObject
{
    private RealmList<Routine> routines;

    public RealmList<Routine> getRoutines()
    {
        return routines;
    }
    public void setRoutines(RealmList<Routine> routines)
    {
        this.routines = routines;
    }
}
