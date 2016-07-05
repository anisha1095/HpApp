package com.hp.hpapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);  //Builder is a static inner class of AlertDialog , builder is a helping class
        builder.setTitle("Fire Missiles");
        builder.setMessage("Are you sure you want to fire the missile?");
        //adding buttons
        builder.setPositiveButton("Fire", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(AlertDialogActivity.this,"Missile Fired",Toast.LENGTH_LONG).show();

            }
        });//end of statement
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(AlertDialogActivity.this,"Missile Not Fired",Toast.LENGTH_LONG).show();
            }
        });//end of statement
        AlertDialog dialog=builder.create();    //now create the outer object which will create the graphics of the dialog box.
        dialog.show();

    }//end of onCreate()

}//end of AlertDialog
