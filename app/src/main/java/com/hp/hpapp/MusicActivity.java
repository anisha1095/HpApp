package com.hp.hpapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MusicActivity extends AppCompatActivity {
  Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        i = new Intent(this,MusicService.class);
    }
    public void starts(View v){
        startService(i);
    }
    public void stops(View v){
        stopService(i);
    }
}
