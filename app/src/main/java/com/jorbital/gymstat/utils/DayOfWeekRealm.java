package com.jorbital.gymstat.utils;

import org.threeten.bp.DayOfWeek;

import io.realm.RealmObject;

public class DayOfWeekRealm extends RealmObject
{
    private String dayOfWeek;

    public void setEnum(DayOfWeek val)
    {
        this.dayOfWeek = val.toString();
    }

    public DayOfWeek getEnum()
    {
        return DayOfWeek.valueOf(dayOfWeek);
    }
}
