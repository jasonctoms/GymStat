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

        //TODO: add the default exercises here
        List<String> defaultExercises = new ArrayList<>();

        String barbellBenchName = context.getString(R.string.barbell_bench);
        defaultExercises.add(barbellBenchName);


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
                //TODO: set image
            }
        });
    }
}
