package com.jorbital.gymstat.views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.jorbital.gymstat.R;
import com.jorbital.gymstat.data.ExerciseObject;
import com.jorbital.gymstat.databinding.ActivityExerciseListBinding;
import com.jorbital.gymstat.viewmodels.ExerciseListViewModel;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;

public class ExerciseListActivity extends AppCompatActivity
{
    private OrderedRealmCollection<ExerciseObject> allExercises;
    private Realm realm;
    private ActivityExerciseListBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this, R.layout.activity_exercise_list);
        b.setActivity(this);

        setSupportActionBar(b.toolbar);

        realm = Realm.getDefaultInstance();

        CreateViewModel();

        b.exerciseRv.setHasFixedSize(true);
        b.exerciseRv.setAdapter(new ExerciseListAdapter(allExercises, true));
        b.exerciseRv.setLayoutManager(new LinearLayoutManager(this));
    }

    private void CreateViewModel()
    {
        ExerciseListViewModel vm = new ExerciseListViewModel(realm);
        vm.makeListOfExercises();
        allExercises = vm.getAllExercises();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        b.exerciseRv.setAdapter(null);
        realm.close();
    }

    public void fabClicked(View view)
    {
        Toast.makeText(this, "This will let the user add a new exercise to the database, or save the selection if multiple items are selected.", Toast.LENGTH_LONG)
                .show();
    }
}
