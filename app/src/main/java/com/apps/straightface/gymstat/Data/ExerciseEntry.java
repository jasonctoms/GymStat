package com.apps.straightface.gymstat.Data;

import com.apps.straightface.gymstat.Utils.WeightUnitRealm;

import java.util.Date;

import io.realm.RealmObject;

public class ExerciseEntry extends RealmObject
{
    private Date date;
    private int setNumber;
    private double weight;
    private WeightUnitRealm unit;
    private int numberOfReps;
    private boolean bestSet;

    public Date getDate()
    {
        return date;
    }
    public void setDate(Date date)
    {
        this.date = date;
    }

    public int getSetNumber()
    {
        return setNumber;
    }
    public void setSetNumber(int setNumber)
    {
        this.setNumber = setNumber;
    }

    public double getWeight()
    {
        return weight;
    }
    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public WeightUnitRealm getUnit()
    {
        return unit;
    }
    public void setUnit(WeightUnitRealm unit)
    {
        this.unit = unit;
    }

    public int getNumberOfReps()
    {
        return numberOfReps;
    }
    public void setNumberOfReps(int numberOfReps)
    {
        this.numberOfReps = numberOfReps;
    }

    public boolean isBestSet()
    {
        return bestSet;
    }
    public void setBestSet(boolean bestSet)
    {
        this.bestSet = bestSet;
    }
}
