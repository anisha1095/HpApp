package com.hp.hpapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {
   Thread t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);  //Builder is a static inner class of AlertDialog , builder is a helping class
        builder.setTitle("Welcome");
        builder.setMessage("Welcome to HP!, Anisha!!");
        AlertDialog dialog=builder.create();
        dialog.show();

        t= new Thread()
        {
          public void run(){
              try{
                  t.sleep(3000);
                  Intent i=new Intent(SplashActivity.this,ListingActivity.class);
                  startActivity(i);
                  finish();

              }catch(Exception e){}
          }
        };
        t.start();
    }
}
