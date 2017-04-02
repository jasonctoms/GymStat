package com.jorbital.gymstat.views;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.jorbital.gymstat.R;
import com.jorbital.gymstat.data.ExerciseObject;
import com.jorbital.gymstat.utils.RecyclerViewClickListener;
import com.jorbital.gymstat.utils.RecyclerViewTouchListener;
import com.jorbital.gymstat.viewmodels.ExerciseListViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.OrderedRealmCollection;
import io.realm.Realm;

public class ExerciseListActivity extends AppCompatActivity
{
    @BindView(R.id.add_exercise_fab) FloatingActionButton fab;
    @BindView(R.id.exercise_rv) RecyclerView exerciseList;
    @BindView(R.id.toolbar) Toolbar toolbar;

    private OrderedRealmCollection<ExerciseObject> allExercises;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        realm = Realm.getDefaultInstance();

        CreateViewModel();

        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "This will let the user add a new exercise to the database, or save the selection if multiple items are selected.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        exerciseList.setHasFixedSize(true);
        exerciseList.setAdapter(new ExerciseListAdapter(allExercises, true));
        exerciseList.setLayoutManager(new LinearLayoutManager(this));

        exerciseList.addOnItemTouchListener(new RecyclerViewTouchListener(this,
                exerciseList, new RecyclerViewClickListener()
        {
            @Override
            public void onClick(View view, final int position)
            {
                Toast.makeText(ExerciseListActivity.this, "Single Click on position: " + position,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position)
            {
                Toast.makeText(ExerciseListActivity.this, "Long press on position: " + position,
                        Toast.LENGTH_LONG).show();
            }
        }));
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
        exerciseList.setAdapter(null);
        realm.close();
    }
}
