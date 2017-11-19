package com.jorbital.gymstat.data;

import com.jorbital.gymstat.utils.LiveRealmData;

import io.realm.Realm;

import static com.jorbital.gymstat.utils.RealmUtils.asLiveData;

/**
 * This class exists to keep database queries separate from other code
 */

public class RoutineDao {
    private Realm realm;

    public RoutineDao(Realm realm) { this.realm = realm; }

    public LiveRealmData<Routine> findAllRoutines() {
        return asLiveData(realm.where(Routine.class).findAll());
    }
}
