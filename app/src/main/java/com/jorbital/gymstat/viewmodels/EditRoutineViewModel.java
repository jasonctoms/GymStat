package com.jorbital.gymstat.viewmodels;

import com.jorbital.gymstat.data.Exercise;
import com.jorbital.gymstat.data.Routine;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;

public class EditRoutineViewModel
{
    private Realm realm;
    private Routine selectedRoutine;
    private OrderedRealmCollection<Exercise> routineExercises;

    public Routine getSelectedRoutine()
    {
        return selectedRoutine;
    }
    private void setSelectedRoutine(String key)
    {
        this.selectedRoutine = realm.where(Routine.class).equalTo("idKey", key).findFirst();
    }

    public OrderedRealmCollection<Exercise> getRoutineExercises()
    {
        return routineExercises;
    }
    private void setRoutineExercises(OrderedRealmCollection<Exercise> routineExercises)
    {
        this.routineExercises = routineExercises;
    }

    public EditRoutineViewModel(Realm r)
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
        setRoutineExercises(selectedRoutine.getExercises());
    }
}
