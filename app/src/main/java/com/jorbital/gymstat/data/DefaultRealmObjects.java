package com.jorbital.gymstat.data;

import android.content.Context;

import com.jorbital.gymstat.R;
import com.jorbital.gymstat.utils.DayOfWeekRealm;
import com.jorbital.gymstat.utils.GymStatEnums;
import com.jorbital.gymstat.utils.MuscleGroupRealm;

import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDateTime;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class DefaultRealmObjects
{
    private Realm mRealm;

    public void initializeDefaultRealmObjects(Context context)
    {
        mRealm = Realm.getDefaultInstance();

        //delete everything for now, during testing
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.deleteAll();
            }
        });

        createMuscleGroupRealmObjects();
        createDayOfWeekRealmObjects();
        createDefaultExercises(context);
        
        //TODO: remove this later
        addTestRoutines();
    }

    //TODO: add the default exercises here
    private void createDefaultExercises(Context context)
    {
        final Context c = context;

        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                ExerciseObject e = realm.createObject(ExerciseObject.class, UUID.randomUUID().toString());
                e.setName(c.getString(R.string.e_bb_bench));
                //TODO: set muscle groups and image asset
            }
        });

        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                ExerciseObject e = realm.createObject(ExerciseObject.class, UUID.randomUUID().toString());
                e.setName(c.getString(R.string.e_db_bench));
                //TODO: set muscle groups and image asset
            }
        });

        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                ExerciseObject e = realm.createObject(ExerciseObject.class, UUID.randomUUID().toString());
                e.setName(c.getString(R.string.e_bb_incline_bench));
                //TODO: set muscle groups and image asset
            }
        });

        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                ExerciseObject e = realm.createObject(ExerciseObject.class, UUID.randomUUID().toString());
                e.setName(c.getString(R.string.e_db_incline_bench));
                //TODO: set muscle groups and image asset
            }
        });

        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                ExerciseObject e = realm.createObject(ExerciseObject.class, UUID.randomUUID().toString());
                e.setName(c.getString(R.string.e_bb_decline_bench));
                //TODO: set muscle groups and image asset
            }
        });

        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                ExerciseObject e = realm.createObject(ExerciseObject.class, UUID.randomUUID().toString());
                e.setName(c.getString(R.string.e_db_decline_bench));
                //TODO: set muscle groups and image asset
            }
        });

        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                ExerciseObject e = realm.createObject(ExerciseObject.class, UUID.randomUUID().toString());
                e.setName(c.getString(R.string.e_bb_squat));
                //TODO: set muscle groups and image asset
            }
        });

        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                ExerciseObject e = realm.createObject(ExerciseObject.class, UUID.randomUUID().toString());
                e.setName(c.getString(R.string.e_db_squat));
                //TODO: set muscle groups and image asset
            }
        });

        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                ExerciseObject e = realm.createObject(ExerciseObject.class, UUID.randomUUID().toString());
                e.setName(c.getString(R.string.e_bb_shoulder_press_standing));
                //TODO: set muscle groups and image asset
            }
        });

        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                ExerciseObject e = realm.createObject(ExerciseObject.class, UUID.randomUUID().toString());
                e.setName(c.getString(R.string.e_db_shoulder_press_standing));
                //TODO: set muscle groups and image asset
            }
        });

        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                ExerciseObject e = realm.createObject(ExerciseObject.class, UUID.randomUUID().toString());
                e.setName(c.getString(R.string.e_bb_shoulder_press_seated));
                //TODO: set muscle groups and image asset
            }
        });

        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                ExerciseObject e = realm.createObject(ExerciseObject.class, UUID.randomUUID().toString());
                e.setName(c.getString(R.string.e_db_shoulder_press_seated));
                //TODO: set muscle groups and image asset
            }
        });

        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                ExerciseObject e = realm.createObject(ExerciseObject.class, UUID.randomUUID().toString());
                e.setName(c.getString(R.string.e_bb_bicep_curl));
                //TODO: set muscle groups and image asset
            }
        });

        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                ExerciseObject e = realm.createObject(ExerciseObject.class, UUID.randomUUID().toString());
                e.setName(c.getString(R.string.e_db_bicep_curl));
                //TODO: set muscle groups and image asset
            }
        });

        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                ExerciseObject e = realm.createObject(ExerciseObject.class, UUID.randomUUID().toString());
                e.setName(c.getString(R.string.e_bb_tricep_extension));
                //TODO: set muscle groups and image asset
            }
        });

        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                ExerciseObject e = realm.createObject(ExerciseObject.class, UUID.randomUUID().toString());
                e.setName(c.getString(R.string.e_db_tricep_extension));
                //TODO: set muscle groups and image asset
            }
        });

        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                ExerciseObject e = realm.createObject(ExerciseObject.class, UUID.randomUUID().toString());
                e.setName(c.getString(R.string.e_lat_pulldown));
                //TODO: set muscle groups and image asset
            }
        });

        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                ExerciseObject e = realm.createObject(ExerciseObject.class, UUID.randomUUID().toString());
                e.setName(c.getString(R.string.e_lat_pulldown));
                //TODO: set muscle groups and image asset
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

    private void createMuscleGroupRealmObjects()
    {
        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                MuscleGroupRealm arms = realm.createObject(MuscleGroupRealm.class);
                arms.setEnum(GymStatEnums.MuscleGroup.ARMS);
            }
        });
        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                MuscleGroupRealm shoulders = realm.createObject(MuscleGroupRealm.class);
                shoulders.setEnum(GymStatEnums.MuscleGroup.SHOULDERS);
            }
        });
        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                MuscleGroupRealm chest = realm.createObject(MuscleGroupRealm.class);
                chest.setEnum(GymStatEnums.MuscleGroup.CHEST);
            }
        });
        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                MuscleGroupRealm upperBack = realm.createObject(MuscleGroupRealm.class);
                upperBack.setEnum(GymStatEnums.MuscleGroup.UPPERBACK);
            }
        });
        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                MuscleGroupRealm lowerBack = realm.createObject(MuscleGroupRealm.class);
                lowerBack.setEnum(GymStatEnums.MuscleGroup.LOWERBACK);
            }
        });
        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                MuscleGroupRealm legs = realm.createObject(MuscleGroupRealm.class);
                legs.setEnum(GymStatEnums.MuscleGroup.LEGS);
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
