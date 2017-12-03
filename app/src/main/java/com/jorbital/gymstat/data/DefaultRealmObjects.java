package com.jorbital.gymstat.data;

import android.content.Context;

import com.jorbital.gymstat.R;
import com.jorbital.gymstat.utils.DayOfWeekRealm;
import com.jorbital.gymstat.utils.MuscleGroup;

import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDateTime;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class DefaultRealmObjects
{
    public void initializeDefaultRealmObjects(Context context)
    {
        Realm realm = Realm.getDefaultInstance();

        //delete everything for now, during testing
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.deleteAll();
            }
        });

        createMuscleGroupRealmObjects(realm);
        createDayOfWeekRealmObjects(realm);
        createDefaultExercises(realm, context);

        //TODO: remove this later
        addTestRoutines(realm);

        realm.close();
    }

    //TODO: add the default exercises here
    private void createDefaultExercises(Realm realm, Context context)
    {
        final Context c = context;

        realm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                RealmResults<MuscleGroupRealm> chestAndArms = realm.where(MuscleGroupRealm.class).
                        equalTo("muscleGroup", MuscleGroup.CHEST).or().
                        equalTo("muscleGroup", MuscleGroup.ARMS).
                        findAll();

                createExercise(realm, c.getString(R.string.e_bb_bench), "file:///android_asset/ex_bb_bench_press.jpg", chestAndArms);

                createExercise(realm, c.getString(R.string.e_db_bench), "file:///android_asset/ex_db_bench_press.jpg", chestAndArms);

                createExercise(realm, c.getString(R.string.e_bb_incline_bench), "file:///android_asset/ex_bb_incline_bench_press.jpg", chestAndArms);

                createExercise(realm, c.getString(R.string.e_db_incline_bench), "file:///android_asset/ex_default.png", chestAndArms);

                createExercise(realm, c.getString(R.string.e_bb_decline_bench), "file:///android_asset/ex_default.png", chestAndArms);

                createExercise(realm, c.getString(R.string.e_db_decline_bench), "file:///android_asset/ex_default.png", chestAndArms);


                RealmResults<MuscleGroupRealm> legsAndLowerBack = realm.where(MuscleGroupRealm.class).
                        equalTo("muscleGroup", MuscleGroup.LEGS  ).or().
                        equalTo("muscleGroup", MuscleGroup.LOWERBACK  ).
                        findAll();

                createExercise(realm, c.getString(R.string.e_bb_squat), "file:///android_asset/ex_default.png", legsAndLowerBack);

                createExercise(realm, c.getString(R.string.e_db_squat), "file:///android_asset/ex_default.png", legsAndLowerBack);


                RealmResults<MuscleGroupRealm> shouldersAndArms = realm.where(MuscleGroupRealm.class).
                        equalTo("muscleGroup", MuscleGroup.SHOULDERS  ).or().
                        equalTo("muscleGroup", MuscleGroup.ARMS  ).
                        findAll();

                createExercise(realm, c.getString(R.string.e_bb_shoulder_press_standing), "file:///android_asset/ex_default.png", shouldersAndArms);

                createExercise(realm, c.getString(R.string.e_db_shoulder_press_standing), "file:///android_asset/ex_default.png", shouldersAndArms);

                createExercise(realm, c.getString(R.string.e_bb_shoulder_press_seated), "file:///android_asset/ex_bb_seated_shoulder_press.jpg", shouldersAndArms);

                createExercise(realm, c.getString(R.string.e_db_shoulder_press_seated), "file:///android_asset/ex_db_seated_shoulder_press.jpg", shouldersAndArms);

                createExercise(realm, c.getString(R.string.e_bb_tricep_extension), "file:///android_asset/ex_default.png", shouldersAndArms);

                createExercise(realm, c.getString(R.string.e_db_tricep_extension), "file:///android_asset/ex_default.png", shouldersAndArms);

                createExercise(realm, c.getString(R.string.e_side_lateral_raise), "file:///android_asset/ex_side_lateral_raise.jpg", shouldersAndArms);


                RealmResults<MuscleGroupRealm> arms = realm.where(MuscleGroupRealm.class).
                        equalTo("muscleGroup", MuscleGroup.ARMS  ).
                        findAll();

                createExercise(realm, c.getString(R.string.e_bb_bicep_curl), "file:///android_asset/ex_default.png", arms);

                createExercise(realm, c.getString(R.string.e_db_bicep_curl), "file:///android_asset/ex_default.png", arms);


                RealmResults<MuscleGroupRealm> shouldersArmsAndUpperBack = realm.where(MuscleGroupRealm.class).
                        equalTo("muscleGroup", MuscleGroup.SHOULDERS  ).or().
                        equalTo("muscleGroup", MuscleGroup.ARMS  ).or().
                        equalTo("muscleGroup", MuscleGroup.UPPERBACK  ).
                        findAll();

                createExercise(realm, c.getString(R.string.e_lat_pulldown), "file:///android_asset/ex_default.png", shouldersArmsAndUpperBack);
            }
        });
    }

    private void createExercise(Realm realm, String name, String imagePath, RealmResults<MuscleGroupRealm> muscleGroups){
        ExerciseObject e = realm.createObject(ExerciseObject.class, UUID.randomUUID().toString());
        e.setName(name);
        e.setImagePath(imagePath);
        for (MuscleGroupRealm muscleGroup : muscleGroups)
        {
            e.getMuscleGroup().add(muscleGroup);
        }
    }

    private void createDayOfWeekRealmObjects(Realm realm)
    {
        realm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                DayOfWeekRealm monday = realm.createObject(DayOfWeekRealm.class);
                monday.setEnum(DayOfWeek.MONDAY);

                DayOfWeekRealm tuesday = realm.createObject(DayOfWeekRealm.class);
                tuesday.setEnum(DayOfWeek.TUESDAY);

                DayOfWeekRealm wednesday = realm.createObject(DayOfWeekRealm.class);
                wednesday.setEnum(DayOfWeek.WEDNESDAY);

                DayOfWeekRealm thursday = realm.createObject(DayOfWeekRealm.class);
                thursday.setEnum(DayOfWeek.THURSDAY);

                DayOfWeekRealm friday = realm.createObject(DayOfWeekRealm.class);
                friday.setEnum(DayOfWeek.FRIDAY);

                DayOfWeekRealm saturday = realm.createObject(DayOfWeekRealm.class);
                saturday.setEnum(DayOfWeek.SATURDAY);

                DayOfWeekRealm sunday = realm.createObject(DayOfWeekRealm.class);
                sunday.setEnum(DayOfWeek.SUNDAY);
            }
        });
    }

    private void createMuscleGroupRealmObjects(Realm realm)
    {
        realm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                MuscleGroupRealm arms = realm.createObject(MuscleGroupRealm.class);
                arms.setMuscleGroup(MuscleGroup.ARMS);

                MuscleGroupRealm shoulders = realm.createObject(MuscleGroupRealm.class);
                shoulders.setMuscleGroup(MuscleGroup.SHOULDERS);

                MuscleGroupRealm chest = realm.createObject(MuscleGroupRealm.class);
                chest.setMuscleGroup(MuscleGroup.CHEST);

                MuscleGroupRealm upperBack = realm.createObject(MuscleGroupRealm.class);
                upperBack.setMuscleGroup(MuscleGroup.UPPERBACK);

                MuscleGroupRealm lowerBack = realm.createObject(MuscleGroupRealm.class);
                lowerBack.setMuscleGroup(MuscleGroup.LOWERBACK);

                MuscleGroupRealm legs = realm.createObject(MuscleGroupRealm.class);
                legs.setMuscleGroup(MuscleGroup.LEGS);
            }
        });
    }

    private void addTestRoutines(Realm realm)
    {
        //before you can add objects to lists in realm, the objects must exist in realm.
        //this is why things have to be done in multiple transactions
        realm.executeTransaction(new Realm.Transaction()
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

        realm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                Routine routine1 = realm.createObject(Routine.class, UUID.randomUUID().toString());
                routine1.setName("Test routine 1");

                RealmResults<DayOfWeekRealm> monday = realm.where(DayOfWeekRealm.class).equalTo("dayOfWeek", DayOfWeek.MONDAY.name()).findAll();
                RealmResults<DayOfWeekRealm> wednesday = realm.where(DayOfWeekRealm.class).equalTo("dayOfWeek", DayOfWeek.WEDNESDAY.name()).findAll();
                routine1.getDays().add(monday.get(0));
                routine1.getDays().add(wednesday.get(0));

                LocalDateTime routine1Date = LocalDateTime.of(2017, 3, 12, 0, 0, 0);
                routine1.setLastCompletedDate(routine1Date.toString());

                RealmResults<Exercise> exercises = realm.where(Exercise.class).findAll();
                routine1.getExercises().add(exercises.get(0));
                exercises.get(0).setConnectedRoutine(routine1.getIdKey());
                routine1.getExercises().add(exercises.get(1));
                exercises.get(1).setConnectedRoutine(routine1.getIdKey());


                Routine routine2 = realm.createObject(Routine.class, UUID.randomUUID().toString());
                routine2.setName("Test routine 2");

                RealmResults<DayOfWeekRealm> tuesday = realm.where(DayOfWeekRealm.class).equalTo("dayOfWeek", DayOfWeek.TUESDAY.name()).findAll();
                RealmResults<DayOfWeekRealm> thursday = realm.where(DayOfWeekRealm.class).equalTo("dayOfWeek", DayOfWeek.THURSDAY.name()).findAll();
                routine2.getDays().add(tuesday.get(0));
                routine2.getDays().add(thursday.get(0));

                LocalDateTime routine2Date = LocalDateTime.of(2017, 4, 12, 0, 0, 0);
                routine2.setLastCompletedDate(routine2Date.toString());

                routine2.getExercises().add(exercises.get(2));
                exercises.get(2).setConnectedRoutine(routine2.getIdKey());
                routine2.getExercises().add(exercises.get(3));
                exercises.get(3).setConnectedRoutine(routine2.getIdKey());
            }
        });
    }
}
