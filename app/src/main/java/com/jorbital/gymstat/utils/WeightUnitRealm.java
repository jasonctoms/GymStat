package com.jorbital.gymstat.utils;

import io.realm.RealmObject;

public class WeightUnitRealm extends RealmObject
{
    private String weightUnit;

    public void setEnum(GymStatEnums.WeightUnit val)
    {
        this.weightUnit = val.toString();
    }

    public GymStatEnums.WeightUnit getEnum()
    {
        return GymStatEnums.WeightUnit.valueOf(weightUnit);
    }
}
