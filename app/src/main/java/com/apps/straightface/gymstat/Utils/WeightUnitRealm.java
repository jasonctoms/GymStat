package com.apps.straightface.gymstat.Utils;

import io.realm.RealmObject;

public class WeightUnitRealm extends RealmObject
{
    private String enumDescription;

    public void setEnum(GymStatEnums.WeightUnit val)
    {
        this.enumDescription = val.toString();
    }

    public GymStatEnums.WeightUnit getEnum()
    {
        return GymStatEnums.WeightUnit.valueOf(enumDescription);
    }
}
