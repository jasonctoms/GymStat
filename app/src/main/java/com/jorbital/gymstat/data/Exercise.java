package com.jorbital.gymstat.data;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Exercise extends RealmObject
{
    @PrimaryKey
    private String idKey;

    private ExerciseObject exerciseType;
    private int numberOfSets;
    private RealmList<ExerciseEntry> exerciseEntries;

    private String connectedRoutine;

    public String getIdKey()
    {
        return idKey;
    }

    public String getConnectedRoutine()
    {
        return connectedRoutine;
    }
    public void setConnectedRoutine(String connectedRoutine)
    {
        this.connectedRoutine = connectedRoutine;
    }

    public ExerciseObject getExerciseType()
    {
        return exerciseType;
    }
    public void setExerciseType(ExerciseObject exerciseType)
    {
        this.exerciseType = exerciseType;
    }

    public int getNumberOfSets()
    {
        return numberOfSets;
    }
    public void setNumberOfSets(int numberOfSets)
    {
        this.numberOfSets = numberOfSets;
    }

    public RealmList<ExerciseEntry> getExerciseEntries()
    {
        return exerciseEntries;
    }
    public void setExerciseEntries(RealmList<ExerciseEntry> exerciseEntries)
    {
        this.exerciseEntries = exerciseEntries;
    }
}
