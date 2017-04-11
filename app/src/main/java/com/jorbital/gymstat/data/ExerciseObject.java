package com.jorbital.gymstat.data;

import com.jorbital.gymstat.utils.MuscleGroupRealm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class ExerciseObject extends RealmObject
{
    @PrimaryKey
    private String idKey;

    private String name;
    private RealmList<MuscleGroupRealm> muscleGroup;
    private int imageResource;

    public String getIdKey()
    {
        return idKey;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public RealmList<MuscleGroupRealm> getMuscleGroup()
    {
        return muscleGroup;
    }
    public void setMuscleGroup(RealmList<MuscleGroupRealm> muscleGroup)
    {
        this.muscleGroup = muscleGroup;
    }

    public int getImageResource()
    {
        return imageResource;
    }
    public void setImageResource(int imageResource)
    {
        this.imageResource = imageResource;
    }
}
