package com.apps.straightface.gymstat.Views;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import com.apps.straightface.gymstat.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PlateCalcDialog extends Dialog
{
    @BindView(R.id.plate1) TextView plate1;
    @BindView(R.id.plate2) TextView plate2;
    @BindView(R.id.plate3) TextView plate3;
    @BindView(R.id.plate4) TextView plate4;
    @BindView(R.id.plate5) TextView plate5;
    @BindView(R.id.plate6) TextView plate6;
    @BindView(R.id.plate1_title) TextView plate1Title;
    @BindView(R.id.plate2_title) TextView plate2Title;
    @BindView(R.id.plate3_title) TextView plate3Title;
    @BindView(R.id.plate4_title) TextView plate4Title;
    @BindView(R.id.plate5_title) TextView plate5Title;
    @BindView(R.id.plate6_title) TextView plate6Title;
    @BindView(R.id.bar_type) TextView barTypeText;
    @BindView(R.id.bar_type_switch) Switch barTypeSwitch;
    @BindView(R.id.wanted_plate_weight) EditText wantedWeight;
    @BindView(R.id.increment_plate_weight) ImageButton incrementWeightButton;
    @BindView(R.id.decrement_plate_weight) ImageButton decrementWeightButton;

    public PlateCalcDialog(Context context)
    {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plate_calc_dialog);
        ButterKnife.bind(this);
    }
}
