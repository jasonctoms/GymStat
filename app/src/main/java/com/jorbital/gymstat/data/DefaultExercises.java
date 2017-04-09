package com.jorbital.gymstat.data;

import android.content.Context;

import com.jorbital.gymstat.R;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

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
                realm.delete(ExerciseObject.class);
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
    }

    private void addDefaultExercise(String name)
    {
        final String exerciseName = name;
        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                ExerciseObject e = realm.createObject(ExerciseObject.class);
                e.setName(exerciseName);
                //TODO: set image and muscle groups
            }
        });
    }
}
