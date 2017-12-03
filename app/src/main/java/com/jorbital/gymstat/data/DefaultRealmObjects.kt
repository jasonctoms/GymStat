package com.jorbital.gymstat.data

import android.content.Context
import com.jorbital.gymstat.R
import com.jorbital.gymstat.utils.DayOfWeekRealm
import com.jorbital.gymstat.utils.MuscleGroup
import io.realm.Realm
import io.realm.RealmResults
import org.threeten.bp.DayOfWeek
import org.threeten.bp.LocalDateTime
import java.util.*

class DefaultRealmObjects {
    fun initializeDefaultRealmObjects(context: Context) {
        val realmInstance = Realm.getDefaultInstance()

        //delete everything for now, during testing
        realmInstance.executeTransaction { realm -> realm.deleteAll() }

        createMuscleGroupRealmObjects(realmInstance)
        createDayOfWeekRealmObjects(realmInstance)
        createDefaultExercises(realmInstance, context)

        //TODO: remove this later
        addTestRoutines(realmInstance)

        realmInstance.close()
    }

    //TODO: add the default exercises here
    private fun createDefaultExercises(realmInstance: Realm, context: Context) {

        realmInstance.executeTransaction { realm ->
            val chestAndArms = realm.where(MuscleGroupRealm::class.java).equalTo("muscleGroup", MuscleGroup.CHEST).or().equalTo("muscleGroup", MuscleGroup.ARMS).findAll()

            createExercise(realm, context.getString(R.string.e_bb_bench), "file:///android_asset/ex_bb_bench_press.jpg", chestAndArms)

            createExercise(realm, context.getString(R.string.e_db_bench), "file:///android_asset/ex_db_bench_press.jpg", chestAndArms)

            createExercise(realm, context.getString(R.string.e_bb_incline_bench), "file:///android_asset/ex_bb_incline_bench_press.jpg", chestAndArms)

            createExercise(realm, context.getString(R.string.e_db_incline_bench), "file:///android_asset/ex_default.png", chestAndArms)

            createExercise(realm, context.getString(R.string.e_bb_decline_bench), "file:///android_asset/ex_default.png", chestAndArms)

            createExercise(realm, context.getString(R.string.e_db_decline_bench), "file:///android_asset/ex_default.png", chestAndArms)


            val legsAndLowerBack = realm.where(MuscleGroupRealm::class.java).equalTo("muscleGroup", MuscleGroup.LEGS).or().equalTo("muscleGroup", MuscleGroup.LOWERBACK).findAll()

            createExercise(realm, context.getString(R.string.e_bb_squat), "file:///android_asset/ex_default.png", legsAndLowerBack)

            createExercise(realm, context.getString(R.string.e_db_squat), "file:///android_asset/ex_default.png", legsAndLowerBack)


            val shouldersAndArms = realm.where(MuscleGroupRealm::class.java).equalTo("muscleGroup", MuscleGroup.SHOULDERS).or().equalTo("muscleGroup", MuscleGroup.ARMS).findAll()

            createExercise(realm, context.getString(R.string.e_bb_shoulder_press_standing), "file:///android_asset/ex_default.png", shouldersAndArms)

            createExercise(realm, context.getString(R.string.e_db_shoulder_press_standing), "file:///android_asset/ex_default.png", shouldersAndArms)

            createExercise(realm, context.getString(R.string.e_bb_shoulder_press_seated), "file:///android_asset/ex_bb_seated_shoulder_press.jpg", shouldersAndArms)

            createExercise(realm, context.getString(R.string.e_db_shoulder_press_seated), "file:///android_asset/ex_db_seated_shoulder_press.jpg", shouldersAndArms)

            createExercise(realm, context.getString(R.string.e_bb_tricep_extension), "file:///android_asset/ex_default.png", shouldersAndArms)

            createExercise(realm, context.getString(R.string.e_db_tricep_extension), "file:///android_asset/ex_default.png", shouldersAndArms)

            createExercise(realm, context.getString(R.string.e_side_lateral_raise), "file:///android_asset/ex_side_lateral_raise.jpg", shouldersAndArms)


            val arms = realm.where(MuscleGroupRealm::class.java).equalTo("muscleGroup", MuscleGroup.ARMS).findAll()

            createExercise(realm, context.getString(R.string.e_bb_bicep_curl), "file:///android_asset/ex_default.png", arms)

            createExercise(realm, context.getString(R.string.e_db_bicep_curl), "file:///android_asset/ex_default.png", arms)


            val shouldersArmsAndUpperBack = realm.where(MuscleGroupRealm::class.java).equalTo("muscleGroup", MuscleGroup.SHOULDERS).or().equalTo("muscleGroup", MuscleGroup.ARMS).or().equalTo("muscleGroup", MuscleGroup.UPPERBACK).findAll()

            createExercise(realm, context.getString(R.string.e_lat_pulldown), "file:///android_asset/ex_default.png", shouldersArmsAndUpperBack)
        }
    }

    private fun createExercise(realm: Realm, name: String, imagePath: String, muscleGroups: RealmResults<MuscleGroupRealm>) {
        val e = realm.createObject(ExerciseObject::class.java, UUID.randomUUID().toString())
        e.name = name
        e.imagePath = imagePath
        for (muscleGroup in muscleGroups) {
            e.muscleGroup.add(muscleGroup)
        }
    }

    private fun createDayOfWeekRealmObjects(realmInstance: Realm) {
        realmInstance.executeTransaction { realm ->
            val monday = realm.createObject(DayOfWeekRealm::class.java)
            monday.enum = DayOfWeek.MONDAY

            val tuesday = realm.createObject(DayOfWeekRealm::class.java)
            tuesday.enum = DayOfWeek.TUESDAY

            val wednesday = realm.createObject(DayOfWeekRealm::class.java)
            wednesday.enum = DayOfWeek.WEDNESDAY

            val thursday = realm.createObject(DayOfWeekRealm::class.java)
            thursday.enum = DayOfWeek.THURSDAY

            val friday = realm.createObject(DayOfWeekRealm::class.java)
            friday.enum = DayOfWeek.FRIDAY

            val saturday = realm.createObject(DayOfWeekRealm::class.java)
            saturday.enum = DayOfWeek.SATURDAY

            val sunday = realm.createObject(DayOfWeekRealm::class.java)
            sunday.enum = DayOfWeek.SUNDAY
        }
    }

    private fun createMuscleGroupRealmObjects(realmInstance: Realm) {
        realmInstance.executeTransaction { realm ->
            val arms = realm.createObject(MuscleGroupRealm::class.java)
            arms.muscleGroup = MuscleGroup.ARMS

            val shoulders = realm.createObject(MuscleGroupRealm::class.java)
            shoulders.muscleGroup = MuscleGroup.SHOULDERS

            val chest = realm.createObject(MuscleGroupRealm::class.java)
            chest.muscleGroup = MuscleGroup.CHEST

            val upperBack = realm.createObject(MuscleGroupRealm::class.java)
            upperBack.muscleGroup = MuscleGroup.UPPERBACK

            val lowerBack = realm.createObject(MuscleGroupRealm::class.java)
            lowerBack.muscleGroup = MuscleGroup.LOWERBACK

            val legs = realm.createObject(MuscleGroupRealm::class.java)
            legs.muscleGroup = MuscleGroup.LEGS
        }
    }

    private fun addTestRoutines(realmInstance: Realm) {
        //before you can add objects to lists in realmInstance, the objects must exist in realmInstance.
        //this is why things have to be done in multiple transactions
        realmInstance.executeTransaction { realm ->
            val exercises = realm.where(ExerciseObject::class.java).findAll()
            val exercise1 = realm.createObject(Exercise::class.java, UUID.randomUUID().toString())
            exercise1.exerciseType = exercises[0]
            exercise1.numberOfSets = 4

            val exercise2 = realm.createObject(Exercise::class.java, UUID.randomUUID().toString())
            exercise2.exerciseType = exercises[1]
            exercise2.numberOfSets = 3

            val exercise3 = realm.createObject(Exercise::class.java, UUID.randomUUID().toString())
            exercise3.exerciseType = exercises[2]
            exercise3.numberOfSets = 2

            val exercise4 = realm.createObject(Exercise::class.java, UUID.randomUUID().toString())
            exercise4.exerciseType = exercises[3]
            exercise4.numberOfSets = 1
        }

        realmInstance.executeTransaction { realm ->
            val routine1 = realm.createObject(Routine::class.java, UUID.randomUUID().toString())
            routine1.name = "Test routine 1"

            val monday = realm.where(DayOfWeekRealm::class.java).equalTo("dayOfWeek", DayOfWeek.MONDAY.name).findAll()
            val wednesday = realm.where(DayOfWeekRealm::class.java).equalTo("dayOfWeek", DayOfWeek.WEDNESDAY.name).findAll()
            routine1.days.add(monday[0])
            routine1.days.add(wednesday[0])

            val routine1Date = LocalDateTime.of(2018, 3, 12, 0, 0, 0)
            routine1.lastCompletedDate = routine1Date.toString()

            val exercises = realm.where(Exercise::class.java).findAll()
            routine1.exercises.add(exercises[0])
            exercises[0]!!.connectedRoutine = routine1.idKey
            routine1.exercises.add(exercises[1])
            exercises[1]!!.connectedRoutine = routine1.idKey


            val routine2 = realm.createObject(Routine::class.java, UUID.randomUUID().toString())
            routine2.name = "Test routine 2"

            val tuesday = realm.where(DayOfWeekRealm::class.java).equalTo("dayOfWeek", DayOfWeek.TUESDAY.name).findAll()
            val thursday = realm.where(DayOfWeekRealm::class.java).equalTo("dayOfWeek", DayOfWeek.THURSDAY.name).findAll()
            routine2.days.add(tuesday[0])
            routine2.days.add(thursday[0])

            val routine2Date = LocalDateTime.of(2018, 4, 12, 0, 0, 0)
            routine2.lastCompletedDate = routine2Date.toString()

            routine2.exercises.add(exercises[2])
            exercises[2]!!.connectedRoutine = routine2.idKey
            routine2.exercises.add(exercises[3])
            exercises[3]!!.connectedRoutine = routine2.idKey
        }
    }
}
