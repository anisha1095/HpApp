package com.hp.hpapp;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class WifiActivity extends AppCompatActivity {
  WifiManager wm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        wm=(WifiManager)getSystemService(Context.WIFI_SERVICE);
    }
    public void on(View v){
        wm.setWifiEnabled(true);
        Toast.makeText(this,"wifi enabled",Toast.LENGTH_LONG).show();
        WifiInfo wi= wm.getConnectionInfo();
        if(wi.getBSSID()!=null){  //basic service set identifier
            String name=wi.getSSID();
            int signalFrequency=wi.getRssi();
            int i=wm.calculateSignalLevel(signalFrequency,10);
            Toast.makeText(this,"wifi name"+name,Toast.LENGTH_LONG).show();
            Toast.makeText(this,"Strength(10)"+i,Toast.LENGTH_LONG).show();
        }

    }
    public void off(View v){
        wm.setWifiEnabled(false);
        Toast.makeText(this,"wifi disabled",Toast.LENGTH_LONG).show();
    }
}
