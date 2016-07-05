package com.hp.hpapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ListInDialogActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_in_dialog);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("choose color");
        final String color[]={"Red","Blue","White","Yellow","Purple","Pink","Black","Grey","Green","Orange","Magenta","Peach"};
        builder.setItems(color, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int i)
            {
                Toast.makeText(ListInDialogActivity.this, color[i],Toast.LENGTH_LONG).show();

            }
        });//end of statement
        AlertDialog dialog=builder.create();    //now create the outer object which will create the graphics of the dialog box.
        dialog.show();
    }

}
