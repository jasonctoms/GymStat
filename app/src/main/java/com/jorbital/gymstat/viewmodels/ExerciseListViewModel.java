package com.jorbital.gymstat.viewmodels;

import com.jorbital.gymstat.data.ExerciseObject;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmResults;

public class ExerciseListViewModel
{
    private Realm realm;
    private OrderedRealmCollection<ExerciseObject> allExercises;

    public OrderedRealmCollection<ExerciseObject> getAllExercises()
    {
        return allExercises;
    }
    private void setAllExercises(OrderedRealmCollection<ExerciseObject> allExercises)
    {
        this.allExercises = allExercises;
    }

    public ExerciseListViewModel()
    {

    }

    public void makeListOfExercises()
    {
        RealmResults<ExerciseObject> exercises = realm.where(ExerciseObject.class).findAll();

        setAllExercises(exercises);
    }
}
