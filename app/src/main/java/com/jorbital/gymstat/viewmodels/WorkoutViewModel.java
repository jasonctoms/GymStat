package com.jorbital.gymstat.viewmodels;


import com.jorbital.gymstat.data.Exercise;
import com.jorbital.gymstat.data.Routine;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;

import static android.R.attr.id;

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
        makeListOfExercises();
    }

    private void makeListOfExercises()
    {
        setWorkoutExercises(selectedRoutine.getExercises());
    }

    public void changeSetsForExercise(String exerciseId, int newValue)
    {
        if (newValue <= 0 || newValue >= 99) return;
        final String id = exerciseId;
        final int val = newValue;
        realm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                Exercise exercise = realm.where(Exercise.class).equalTo("idKey", id).findFirst();
                exercise.setNumberOfSets(val);
                realm.copyToRealmOrUpdate(exercise);
            }
        });
    }
}
