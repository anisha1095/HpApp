package com.hp.hpapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class ServiceDemo extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"ServiceDemo onCreate()",Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"ServiceDemo onStartCommand()",Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent,flags,startId);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"ServiceDemo onDestroy()",Toast.LENGTH_LONG).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
