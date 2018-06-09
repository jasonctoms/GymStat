package com.jorbital.gymstat.views;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.jorbital.gymstat.GymStatStringConstants;
import com.jorbital.gymstat.R;

public class PlateCalcDialog extends Dialog
{
    private Context mContext;

    private int mNumOfPlate1 = 0;
    private int mNumOfPlate2 = 0;
    private int mNumOfPlate3 = 0;
    private int mNumOfPlate4 = 0;
    private int mNumOfPlate5 = 0;
    private int mNumOfPlate6 = 0;
    private int mBarWeight;
    private int mWeightIncrement;
    private String mWeightUnits;
    private String mBarString;

    Switch barTypeSwitch;

    EditText wantedWeight;

    TextView plate1;
    TextView plate2;
    TextView plate3;
    TextView plate4;
    TextView plate5;
    TextView plate6;
    TextView plate1Title;
    TextView plate2Title;
    TextView plate3Title;
    TextView plate4Title;
    TextView plate5Title;
    TextView plate6Title;

    PlateCalcDialog(Context context)
    {
        super(context);
        mContext = context;
    }

    private void setPreferences()
    {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        mWeightUnits = prefs.getString(GymStatStringConstants.WEIGHT_UNIT, GymStatStringConstants.POUNDS);
        mWeightIncrement = 1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plate_calc_dialog);

        setPreferences();

        mBarString = mContext.getResources().getString(R.string.plate_calc_bar_weight);

        updatePlateViews(mNumOfPlate1, mNumOfPlate2, mNumOfPlate3, mNumOfPlate4, mNumOfPlate5, mNumOfPlate6);
        if(mWeightUnits.equals("Kilograms"))
        {
            setPlateTitles("25kg", "20kg", "15kg", "10kg", "5kg", "2.5kg");
            mBarWeight = 20;
            barTypeSwitch.setText(mBarString +"20kg");
        }
        else if (mWeightUnits.equals("Pounds"))
        {
            setPlateTitles("45lbs", "35lbs", "25lbs", "10lbs", "5lbs", "2.5lbs");
            mBarWeight = 45;
            barTypeSwitch.setText(mBarString +"45lbs");
        }

        //TODO: eventually this value can be put in the constructor as current weight
        wantedWeight.setText("0.0");
    }

    /*this method calculates how many of each plate is required for the given
    weight, and calls to set all of the views appropriately*/
    private void calculatePlates(double enteredWeight)
    {
        if(enteredWeight <= 45)
            resetPlateViews();

        double newWeight;

        newWeight = (enteredWeight - mBarWeight) / 2; //removing weight of bar from entered value and
        // breaking into 2 sides of bar

        while(newWeight >= 45)
        {
            mNumOfPlate1++;
            newWeight = newWeight - 45;
            if (newWeight <= 0)
                break;
        }

        while(newWeight >= 35 )
        {
            mNumOfPlate2++;
            newWeight = newWeight - 35;
            if (newWeight <= 0)
                break;
        }

        while(newWeight >= 25 )
        {
            mNumOfPlate3++;
            newWeight = newWeight - 25;
            if (newWeight <= 0)
                break;
        }

        while(newWeight >= 10)
        {
            mNumOfPlate4++;
            newWeight = newWeight - 10;
            if (newWeight <= 0)
                break;
        }

        while(newWeight >= 5)
        {
            mNumOfPlate5++;
            newWeight = newWeight - 5;
            if (newWeight <= 0)
                break;
        }

        while(newWeight >= 2.5)
        {
            mNumOfPlate6++;
            newWeight = newWeight - 2.5;
            if (newWeight <= 0)
                break;
        }

        updatePlateViews(mNumOfPlate1, mNumOfPlate2, mNumOfPlate3, mNumOfPlate4, mNumOfPlate5, mNumOfPlate6);
    }

    //When updated, these will be the number of plates needed *on each side*
    private void updatePlateViews(int n1, int n2, int n3, int n4, int n5, int n6)
    {
        plate1.setText(Integer.toString(n1));
        plate2.setText(Integer.toString(n2));
        plate3.setText(Integer.toString(n3));
        plate4.setText(Integer.toString(n4));
        plate5.setText(Integer.toString(n5));
        plate6.setText(Integer.toString(n6));
    }

    private void resetPlateViews()
    {
        mNumOfPlate1 = 0;
        mNumOfPlate2 = 0;
        mNumOfPlate3 = 0;
        mNumOfPlate4 = 0;
        mNumOfPlate5 = 0;
        mNumOfPlate6 = 0;
        updatePlateViews(0, 0, 0, 0, 0, 0);
    }

    private void setPlateTitles(String n1, String n2, String n3, String n4, String n5, String n6)
    {
        plate1Title.setText(n1);
        plate2Title.setText(n2);
        plate3Title.setText(n3);
        plate4Title.setText(n4);
        plate5Title.setText(n5);
        plate6Title.setText(n6);
    }

    public void weightTextChanged(CharSequence text, int start, int before, int count)
    {
        String weightString = text.toString();
        double weight;
        if(weightString.isEmpty())
            updatePlateViews(0, 0, 0, 0, 0, 0);
        else
        {
            weight = Double.parseDouble(weightString);
            calculatePlates(weight);
        }
    }

    public void incrementWeight(View view)
    {
        String currentValue = wantedWeight.getText().toString();
        if (!currentValue.isEmpty())
        {
            double newValue = Double.parseDouble(currentValue);
            newValue += mWeightIncrement;
            if (newValue <= 999999)
                wantedWeight.setText(Double.toString(newValue));
        }
    }

    public void decrementWeight(View view)
    {
        String currentValue = wantedWeight.getText().toString();
        if (!currentValue.isEmpty())
        {
            double newValue = Double.parseDouble(currentValue);
            newValue -= mWeightIncrement;
            if (newValue >= 0)
                wantedWeight.setText(Double.toString(newValue));
        }
    }

    public void barWeightSwitched(boolean isSwitched)
    {
        if (isSwitched)
        {
            barTypeSwitch.setText(mBarString + "55lbs");
            mBarWeight = 55;
        }
        else
        {
            barTypeSwitch.setText(mBarString +"45lbs");
            mBarWeight = 45;
        }
    }
}
