package com.hp.hpapp;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.AvoidXfermode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class DatabaseActivity extends AppCompatActivity {
    TableLayout tl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        tl=(TableLayout)findViewById(R.id.tableLayout1);

        SQLiteDatabase db=openOrCreateDatabase("DemoDB", MODE_APPEND,null);   //if file doesnt exist the open new else just open
        db.execSQL("create table if not exists Student(name varchar,phone varchar)");

        SharedPreferences sp=getSharedPreferences("DemoDB_file",0);
        String msg=sp.getString("STATUS","Not Initialized");
        if(msg.equals("Not Initialized"))
        {
            db.execSQL("insert into Student (name,phone) values('anisha','927849292')");
            db.execSQL("insert into Student (name,phone) values('anvi','8338432322')");
            db.execSQL("insert into Student (name,phone) values('yash','947343222')");
            db.execSQL("insert into Student (name,phone) values('shivangi','9478232121')");
            Toast.makeText(this, "TAble created and records inserted", Toast.LENGTH_LONG).show();
            SharedPreferences.Editor editor =sp.edit();
            editor.putString("STATUS","Initialized");
            editor.commit();
        }

        TableRow tr;
        String q="select *from Student";
        Cursor c= db.rawQuery(q,null);
        String name="",phone="";

        while(c.moveToNext()){
            name=c.getString(0);
            phone=c.getString(1);
           // if(db.rawQuery())
            tr=new TableRow(this);
            TextView tv1= new TextView(this);  //creating new text view using java
            tv1.setText(name);
            TextView tv2=new TextView(this);
            tv2.setText(phone);
            tr.addView(tv1);
            tr.addView(tv2);
            tl.addView(tr);
        }//end of  while
        db.close();
        Toast.makeText(this,"loaded",Toast.LENGTH_LONG).show();
    }//end create()
}//end of class
