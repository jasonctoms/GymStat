package com.jorbital.gymstat.data;

import com.jorbital.gymstat.utils.DayOfWeekRealm;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Routine extends RealmObject
{
    private String name;
    private RealmList<DayOfWeekRealm> days;
    private RealmList<Exercise> exercises;

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
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
