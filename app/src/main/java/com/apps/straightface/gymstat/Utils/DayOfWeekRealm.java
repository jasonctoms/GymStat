package com.apps.straightface.gymstat.Utils;

import org.threeten.bp.DayOfWeek;

import io.realm.RealmObject;

public class DayOfWeekRealm extends RealmObject
{
    private String enumDescription;

    public void setEnum(DayOfWeek val)
    {
        this.enumDescription = val.toString();
    }

    public DayOfWeek getEnum()
    {
        return DayOfWeek.valueOf(enumDescription);
    }
}
