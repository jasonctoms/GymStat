package com.apps.straightface.gymstat.Data;

import io.realm.RealmList;
import io.realm.RealmObject;


public class Exercise extends RealmObject
{
    private ExerciseObject exerciseType;
    private int numberOfSets;
    private RealmList<ExerciseEntry> exerciseEntries;

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
