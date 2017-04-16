package com.jorbital.gymstat.data;

import android.content.Context;

import com.jorbital.gymstat.R;
import com.jorbital.gymstat.utils.DayOfWeekRealm;

import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class DefaultExercises
{
    private Realm mRealm;

    public void initializeDefaultExercises(Context context)
    {
        mRealm = Realm.getDefaultInstance();

        //delete everything for now, during testing
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.deleteAll();
            }
        });

        //TODO: add the default exercises here
        List<String> defaultExercises = new ArrayList<>();

        String bbBenchName = context.getString(R.string.e_bb_bench);
        defaultExercises.add(bbBenchName);
        String dbBenchName = context.getString(R.string.e_db_bench);
        defaultExercises.add(dbBenchName);
        String bbIncBenchName = context.getString(R.string.e_bb_incline_bench);
        defaultExercises.add(bbIncBenchName);
        String dbIncBenchName = context.getString(R.string.e_db_incline_bench);
        defaultExercises.add(dbIncBenchName);
        String bbDecBenchName = context.getString(R.string.e_bb_decline_bench);
        defaultExercises.add(bbDecBenchName);
        String dbBDecBenchName = context.getString(R.string.e_db_decline_bench);
        defaultExercises.add(dbBDecBenchName);
        String bbSquatName = context.getString(R.string.e_bb_squat);
        defaultExercises.add(bbSquatName);
        String dbSquatName = context.getString(R.string.e_db_squat);
        defaultExercises.add(dbSquatName);
        String bbStandingShoulderName = context.getString(R.string.e_bb_shoulder_press_standing);
        defaultExercises.add(bbStandingShoulderName);
        String dbStandingShoulderName = context.getString(R.string.e_db_shoulder_press_standing);
        defaultExercises.add(dbStandingShoulderName);
        String bbSeatedShoulderName = context.getString(R.string.e_bb_shoulder_press_seated);
        defaultExercises.add(bbSeatedShoulderName);
        String dbSeatedShoulderName = context.getString(R.string.e_db_shoulder_press_seated);
        defaultExercises.add(dbSeatedShoulderName);
        String bbBicepCurlName = context.getString(R.string.e_bb_bicep_curl);
        defaultExercises.add(bbBicepCurlName);
        String dbBicepCurlName = context.getString(R.string.e_db_bicep_curl);
        defaultExercises.add(dbBicepCurlName);
        String bbTricepExtensionName = context.getString(R.string.e_bb_tricep_extension);
        defaultExercises.add(bbTricepExtensionName);
        String dbTricepExtensionName = context.getString(R.string.e_db_tricep_extension);
        defaultExercises.add(dbTricepExtensionName);
        String latPullDownName = context.getString(R.string.e_lat_pulldown);
        defaultExercises.add(latPullDownName);
        String sideLateralRaiseName = context.getString(R.string.e_side_lateral_raise);
        defaultExercises.add(sideLateralRaiseName);

        for(String name : defaultExercises)
            addDefaultExercise(name);

        createDayOfWeekRealmObjects();

        //TODO: remove this later
        addTestRoutines();
    }

    private void addDefaultExercise(String name)
    {
        final String exerciseName = name;
        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                ExerciseObject e = realm.createObject(ExerciseObject.class, UUID.randomUUID().toString());
                e.setName(exerciseName);
                //TODO: set image and muscle groups
            }
        });
    }

    private void createDayOfWeekRealmObjects()
    {
        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                DayOfWeekRealm monday = realm.createObject(DayOfWeekRealm.class);
                monday.setEnum(DayOfWeek.MONDAY);
            }
        });
        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                DayOfWeekRealm tuesday = realm.createObject(DayOfWeekRealm.class);
                tuesday.setEnum(DayOfWeek.TUESDAY);
            }
        });
        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                DayOfWeekRealm wednesday = realm.createObject(DayOfWeekRealm.class);
                wednesday.setEnum(DayOfWeek.WEDNESDAY);
            }
        });
        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                DayOfWeekRealm thursday = realm.createObject(DayOfWeekRealm.class);
                thursday.setEnum(DayOfWeek.THURSDAY);
            }
        });
        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                DayOfWeekRealm friday = realm.createObject(DayOfWeekRealm.class);
                friday.setEnum(DayOfWeek.FRIDAY);
            }
        });
        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                DayOfWeekRealm saturday = realm.createObject(DayOfWeekRealm.class);
                saturday.setEnum(DayOfWeek.SATURDAY);
            }
        });
        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                DayOfWeekRealm sunday = realm.createObject(DayOfWeekRealm.class);
                sunday.setEnum(DayOfWeek.SUNDAY);
            }
        });
    }

    private void addTestRoutines()
    {
        //before you can add objects to lists in realm, the objects must exist in realm.
        //this is why things have to be done in multiple transactions
        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                RealmResults<ExerciseObject> exercises = realm.where(ExerciseObject.class).findAll();
                Exercise exercise1 = realm.createObject(Exercise.class, UUID.randomUUID().toString());
                exercise1.setExerciseType(exercises.get(0));
                exercise1.setNumberOfSets(4);

                Exercise exercise2 = realm.createObject(Exercise.class, UUID.randomUUID().toString());
                exercise2.setExerciseType(exercises.get(1));
                exercise2.setNumberOfSets(3);

                Exercise exercise3 = realm.createObject(Exercise.class, UUID.randomUUID().toString());
                exercise3.setExerciseType(exercises.get(2));
                exercise3.setNumberOfSets(2);

                Exercise exercise4 = realm.createObject(Exercise.class, UUID.randomUUID().toString());
                exercise4.setExerciseType(exercises.get(3));
                exercise4.setNumberOfSets(1);
            }
        });

        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                Routine routine1 = realm.createObject(Routine.class, UUID.randomUUID().toString());
                routine1.setName("Test routine 1");

                RealmResults<DayOfWeekRealm> monday = realm.where(DayOfWeekRealm.class).equalTo("dayOfWeek", "MONDAY").findAll();
                RealmResults<DayOfWeekRealm> wednesday = realm.where(DayOfWeekRealm.class).equalTo("dayOfWeek", "WEDNESDAY").findAll();
                routine1.getDays().add(monday.get(0));
                routine1.getDays().add(wednesday.get(0));

                LocalDateTime routine1Date = LocalDateTime.of(2017, 3, 12, 0, 0, 0);
                routine1.setLastCompletedDate(routine1Date.toString());

                RealmResults<Exercise> exercises = realm.where(Exercise.class).findAll();
                routine1.getExercises().add(exercises.get(0));
                routine1.getExercises().add(exercises.get(1));


                Routine routine2 = realm.createObject(Routine.class, UUID.randomUUID().toString());
                routine2.setName("Test routine 2");

                RealmResults<DayOfWeekRealm> tuesday = realm.where(DayOfWeekRealm.class).equalTo("dayOfWeek", "TUESDAY").findAll();
                RealmResults<DayOfWeekRealm> thursday = realm.where(DayOfWeekRealm.class).equalTo("dayOfWeek", "THURSDAY").findAll();
                routine2.getDays().add(tuesday.get(0));
                routine2.getDays().add(thursday.get(0));

                LocalDateTime routine2Date = LocalDateTime.of(2017, 4, 12, 0, 0, 0);
                routine2.setLastCompletedDate(routine2Date.toString());

                routine2.getExercises().add(exercises.get(2));
                routine2.getExercises().add(exercises.get(3));
            }
        });
    }
}
