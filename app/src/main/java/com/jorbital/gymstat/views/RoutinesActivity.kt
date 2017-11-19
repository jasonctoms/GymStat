package com.jorbital.gymstat.views

import kotlinx.android.synthetic.main.activity_routines.*

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View

import com.jorbital.gymstat.R
import com.jorbital.gymstat.data.Routine
import com.jorbital.gymstat.utils.BaseActivityWithNavDrawer
import com.jorbital.gymstat.viewmodels.RoutinesViewModel
import io.realm.RealmResults

class RoutinesActivity : BaseActivityWithNavDrawer() {
    private var vm: RoutinesViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = ViewModelProviders.of(this).get(RoutinesViewModel::class.java)

        vm!!.allRoutines?.observe(this, Observer { updateViewFromViewModel() })

        routinesRv.setHasFixedSize(true)
        routinesRv.layoutManager = LinearLayoutManager(this)

        updateViewFromViewModel()
    }

    override fun setLayout() {
        setContentView(R.layout.activity_routines)
    }

    private fun updateViewFromViewModel() {
        if (vm == null)
            return

        if (vm!!.noRoutines()!!) {
            noRoutinesLayout.visibility = View.VISIBLE
            return
        } else
            noRoutinesLayout.visibility = View.GONE

        if (routinesRv.adapter == null)
            routinesRv.adapter = RoutinesAdapter(vm!!.allRoutines?.value, true)
        else {
            //update the list, maybe not needed if the realm stuff works like magic
        }
    }

    fun addRoutine(view: View) {
        val intent = Intent(this, EditRoutineActivity::class.java)
        startActivity(intent)
    }

    fun startFreeWorkout(view: View) {
        val intent = Intent(this, WorkoutActivity::class.java)
        startActivity(intent)
    }

    fun plateCalculator(view: View) {
        PlateCalcDialog(this).show()
    }
}