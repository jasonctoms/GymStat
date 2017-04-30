package com.jorbital.gymstat.data;

import com.jorbital.gymstat.utils.WeightUnit;

import io.realm.RealmObject;

public class WeightUnitRealm extends RealmObject
{
    private String weightUnit;

    public void setEnum(WeightUnit val)
    {
        this.weightUnit = val.toString();
    }

    public WeightUnit getEnum()
    {
        return WeightUnit.valueOf(weightUnit);
    }
}
