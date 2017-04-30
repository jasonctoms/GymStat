package com.jorbital.gymstat.data;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class ExerciseObject extends RealmObject
{
    @PrimaryKey
    private String idKey;

    private String name;
    private RealmList<MuscleGroupRealm> muscleGroup;
    private String imagePath;

    public String getIdKey()
    {
        return idKey;
    }
    public void setIdKey(String idKey)
    {
        this.idKey = idKey;
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

    public String getImagePath()
    {
        return imagePath;
    }
    public void setImagePath(String imagePath)
    {
        this.imagePath = imagePath;
    }
}
