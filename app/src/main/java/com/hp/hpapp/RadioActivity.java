package com.hp.hpapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RadioActivity extends AppCompatActivity
{   TextView tv1;
     RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        rg=(RadioGroup)findViewById(R.id.radioGroup1);
        tv1=(TextView)findViewById(R.id.textView1);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                String str="You've Selected: ";
                switch(checkedId){
                    case R.id.radioButton1 : str=str+"Breakfast";
                                             break;
                    case R.id.radioButton2 : str=str+"Lunch";
                                              break;
                    case R.id.radioButton3 : str=str+"Dinner";
                                             break;
                    case R.id.radioButton4 : str=str+"All";
                                              break;
                }//end of switch
                tv1.setText(str);


            }
        });//statement terminated

    }//end of onCreate() method

    public void clear(View v){

        rg.clearCheck();
        tv1.setText("You've Selected: None");

    }
}
