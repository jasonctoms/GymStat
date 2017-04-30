package com.jorbital.gymstat.data;

import com.jorbital.gymstat.utils.MuscleGroup;

import io.realm.RealmObject;

public class MuscleGroupRealm extends RealmObject
{
    private String muscleGroup;

    public void setEnum(MuscleGroup val)
    {
        this.muscleGroup = val.toString();
    }

    public MuscleGroup getEnum()
    {
        return MuscleGroup.valueOf(muscleGroup);
    }
}
