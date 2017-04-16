package com.jorbital.gymstat.data;

import com.jorbital.gymstat.utils.DayOfWeekRealm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Routine extends RealmObject
{
    @PrimaryKey
    private String idKey;

    private String name;
    private String lastCompletedDate;
    private RealmList<DayOfWeekRealm> days;
    private RealmList<Exercise> exercises;

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

    public String getLastCompletedDate()
    {
        return lastCompletedDate;
    }
    public void setLastCompletedDate(String lastCompletedDate)
    {
        this.lastCompletedDate = lastCompletedDate;
    }

    public RealmList<DayOfWeekRealm> getDays()
    {
        return days;
    }
    public void setDays(RealmList<DayOfWeekRealm> days)
    {
        this.days = days;
    }

    public RealmList<Exercise> getExercises()
    {
        return exercises;
    }
    public void setExercises(RealmList<Exercise> exercises)
    {
        this.exercises = exercises;
    }
}
