package com.jorbital.gymstat.viewmodels;


import com.jorbital.gymstat.data.Exercise;
import com.jorbital.gymstat.data.Routine;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;

public class WorkoutViewModel
{
    private Realm realm;
    private Routine selectedRoutine;
    private OrderedRealmCollection<Exercise> workoutExercises;

    public Routine getSelectedRoutine()
    {
        return selectedRoutine;
    }
    private void setSelectedRoutine(String key)
    {
        this.selectedRoutine = realm.where(Routine.class).equalTo("idKey", key).findFirst();
    }

    public OrderedRealmCollection<Exercise> getWorkoutExercises()
    {
        return workoutExercises;
    }
    private void setWorkoutExercises(OrderedRealmCollection<Exercise> workoutExercises)
    {
        this.workoutExercises = workoutExercises;
    }

    public WorkoutViewModel(Realm r)
    {
        realm = r;
    }

    public void Init(String key)
    {
        setSelectedRoutine(key);
        makeListofExercises();
    }

    private void makeListofExercises()
    {
        setWorkoutExercises(selectedRoutine.getExercises());
    }
}
