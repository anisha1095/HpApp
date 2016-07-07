package com.hp.hpapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MusicService extends Service implements MediaPlayer.OnCompletionListener {
MediaPlayer mediaPlayer;
    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer=MediaPlayer.create(this,R.raw.fearless); //long running process therefore we'll link with service. if service closed. song closed
        mediaPlayer.setOnCompletionListener(this);   //if song completed->what to do.
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(mediaPlayer.isPlaying()==false){
            mediaPlayer.start();

        }
        Toast.makeText(this,"music playing",Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer.isPlaying()==true){
            mediaPlayer.stop();
        }

        Toast.makeText(this,"Song Stopped",Toast.LENGTH_LONG).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        stopSelf();         //to close a service we write stopSelf ->linked service is closed.
    }
}
