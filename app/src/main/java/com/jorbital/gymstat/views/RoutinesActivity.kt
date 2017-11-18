package com.jorbital.gymstat.views

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.jorbital.gymstat.R
import com.jorbital.gymstat.utils.BaseActivityWithNavDrawer
import com.jorbital.gymstat.viewmodels.RoutinesViewModel
import kotlinx.android.synthetic.main.activity_routines.*

class RoutinesActivity : BaseActivityWithNavDrawer() {
    private var vm: RoutinesViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (vm!!.allRoutines.isEmpty())
            noRoutinesLayout?.visibility = View.VISIBLE

        routinesRv?.setHasFixedSize(true)

        routinesRv?.layoutManager = LinearLayoutManager(this)
    }

    override fun setLayout() {
        setContentView(R.layout.activity_routines)
    }

    override fun createViewModel() {
        vm = RoutinesViewModel(realm)
        vm?.makeListOfRoutines()
    }

    override fun updateViewFromViewModel() {
        if (routinesRv?.adapter == null) {
            routinesRv!!.adapter = RoutinesAdapter(vm!!.allRoutines, true)
        }
        //else
        //update the list
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
