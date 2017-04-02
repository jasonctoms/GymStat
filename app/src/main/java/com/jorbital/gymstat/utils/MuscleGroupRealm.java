package com.jorbital.gymstat.utils;

import io.realm.RealmObject;

public class MuscleGroupRealm extends RealmObject
{
    private String enumDescription;

    public void setEnum(GymStatEnums.MuscleGroup val) {
        this.enumDescription = val.toString();
    }

    public GymStatEnums.MuscleGroup getEnum() {
        return GymStatEnums.MuscleGroup.valueOf(enumDescription);
    }
}
