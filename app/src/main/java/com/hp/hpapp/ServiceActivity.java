package com.hp.hpapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ServiceActivity extends AppCompatActivity {
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        i=new Intent(this,ServiceDemo.class);
    }

    public void starts(View v){
        startService(i);
    }
    public void stops(View v){
        stopService(i);
    }
}
