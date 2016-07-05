package com.hp.hpapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SharedPreferencesActivity extends AppCompatActivity {
   EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        et1= (EditText) findViewById(R.id.editText1);

        SharedPreferences sp=getSharedPreferences("Demofile",0);   //file in which we'll write our edit text value ,to be retrieved later.
                                                                  // retieving here. "0" - private mode.(cannot be used by any other app of the phone
        String msg=sp.getString("STATUS",null);  //STATUS is a variable in the file which stores in the edit text in file.
                 // if you dont find Status variable the alternate value returned is null.(SEc parameter)
        et1.setText(msg);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //creation of Demofile.
        SharedPreferences sp=getSharedPreferences("Demofile",0); //load file-readable format
        SharedPreferences.Editor editor=sp.edit();       //to open in editable mode. 1. if no demofile is created then it will edit else it will open existing file in editable mode
        editor.putString("STATUS",et1.getText().toString());  //if status variable doesnt exist then it will create a new variable and add the text entered, else it will just modify the preexisting value.
        editor.commit();  //saving the values 


    }
}
