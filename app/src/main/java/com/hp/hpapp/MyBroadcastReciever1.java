package com.hp.hpapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

//new ->broadcast activity
public class MyBroadcastReciever1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
       String str=intent.getAction();

        if(str.equals("android.intent.action.ACTION_POWER_CONNECTED")){
            Toast.makeText(context,"Charging started",Toast.LENGTH_LONG).show();

        }
        else{
            Toast.makeText(context,"Discharging",Toast.LENGTH_LONG).show();
        }
    }
}
