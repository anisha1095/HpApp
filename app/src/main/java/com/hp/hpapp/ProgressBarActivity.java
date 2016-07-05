package com.hp.hpapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressBarActivity extends AppCompatActivity {
    ProgressBar p;
    Button b;
    Thread t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        b= (Button) findViewById(R.id.button1);
        p= (ProgressBar) findViewById(R.id.progressBar1);

        t= new Thread()    //creation of anonymous class . object can be used on here and no where else. t is the parent class-> saving a child class
        {
            public void run(){
                for(int i=0;i<=100;i++){
                    p.setProgress(i);
                    try{
                        Thread.sleep(500);  //checked exception
                    }catch(Exception e){

                    }
                }
            }
        };//end of thread

    }//end of oncreate()

    public void startProgress(View v) {
     t.start();
    }
}
