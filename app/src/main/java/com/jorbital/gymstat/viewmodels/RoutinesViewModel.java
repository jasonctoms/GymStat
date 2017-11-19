package com.jorbital.gymstat.viewmodels;

import com.jorbital.gymstat.data.Routine;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmResults;

public class RoutinesViewModel
{
    private Realm realm;
    private OrderedRealmCollection<Routine> allRoutines;

    public OrderedRealmCollection<Routine> getAllRoutines()
    {
        return allRoutines;
    }
    private void setAllRoutines(OrderedRealmCollection<Routine> allRoutines)
    {
        this.allRoutines = allRoutines;
    }

    public RoutinesViewModel()
    {

    }

    public void makeListOfRoutines()
    {
        RealmResults<Routine> routines = realm.where(Routine.class).findAll();

        setAllRoutines(routines);
    }
}
