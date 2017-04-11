package com.jorbital.gymstat.utils;

import io.realm.RealmObject;

public class MuscleGroupRealm extends RealmObject
{
    private String muscleGroup;

    public void setEnum(GymStatEnums.MuscleGroup val) {
        this.muscleGroup = val.toString();
    }

    public GymStatEnums.MuscleGroup getEnum() {
        return GymStatEnums.MuscleGroup.valueOf(muscleGroup);
    }
}
