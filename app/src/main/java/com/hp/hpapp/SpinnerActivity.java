package com.hp.hpapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity
{
    Spinner s1;
    String planets[]={"Earth","Mars","Jupiter","Venus","Pluto","Saturn","Mercury","Uranus","Neptune"};

    void showToast(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }//end of showToast() method
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        s1=(Spinner)findViewById(R.id.spinner1);
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,planets);   //how the spinner looks
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);  // how will the dropdown menu will look
        s1.setAdapter(adapter);   //handing over adapter to spinner
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()    //new object a.b , b inner class
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                showToast("Spinner :"+planets[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                showToast("Spinner: Not Selected");
            }
        }

        ); //Statement termination

    }//end of onCreate() Method
}
