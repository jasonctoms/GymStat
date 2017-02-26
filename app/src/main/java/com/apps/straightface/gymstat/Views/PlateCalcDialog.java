package com.apps.straightface.gymstat.Views;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
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

        incrementWeightButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                calculatePlates();
            }
        });
    }

    /*this method calculates how many of each plate is required for the given
    weight, and calls to set all of the views appropriately*/
    private void calculatePlates()
    {
        int numOfPlate1 = 0;
        int numOfPlate2 = 0;
        int numOfPlate3 = 0;
        int numOfPlate4 = 0;
        int numOfPlate5 = 0;
        int numOfPlate6 = 0;

        //Chris write some logic here
        //Let me know if you find a more eloquent way to do this other than sooo many while loops.
        double enteredWeight = 360; //Test for the thing. Need to implement the user input.
        double newWeight;

        newWeight = (enteredWeight - 45) / 2; //removing weight of bar from entered value and breaking into 2 sides of bar

        while(newWeight >= 45)
        {
            numOfPlate1++;
            newWeight = newWeight - 45;

            if (newWeight <= 0)
            {
                break;
            }
        }

        while(newWeight >= 35 )
        {
            numOfPlate2++;
            newWeight = newWeight - 35;

            if (newWeight <= 0)
            {
                break;
            }
        }

        while(newWeight >= 25 )
        {
            numOfPlate3++;
            newWeight = newWeight - 25;

            if (newWeight <= 0)
            {
                break;
            }
        }

        while(newWeight >= 10)
        {
            numOfPlate4++;
            newWeight = newWeight - 10;

            if (newWeight <= 0)
            {
                break;
            }
        }

        while(newWeight >= 5)
        {
            numOfPlate5++;
            newWeight = newWeight - 5;

            if (newWeight <= 0)
            {
                break;
            }
        }

        while(newWeight >= 2.5)
        {
            numOfPlate6++;
            newWeight = newWeight - 2.5;

            if (newWeight <= 0)
            {
                break;
            }
        }
        //When updated, these will be the number of plates needed *on each side*
        updatePlateViews(numOfPlate1, numOfPlate2, numOfPlate3, numOfPlate4, numOfPlate5, numOfPlate6);
    }

    private void updatePlateViews(int n1, int n2, int n3, int n4, int n5, int n6)
    {
        plate1.setText(Integer.toString(n1));
        plate2.setText(Integer.toString(n2));
        plate3.setText(Integer.toString(n3));
        plate4.setText(Integer.toString(n4));
        plate5.setText(Integer.toString(n5));
        plate6.setText(Integer.toString(n6));
    }
}
