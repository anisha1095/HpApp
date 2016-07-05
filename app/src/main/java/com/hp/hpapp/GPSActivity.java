package com.hp.hpapp;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class GPSActivity extends AppCompatActivity {
    TextView tv;
    LocationManager lm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);
        tv= (TextView) findViewById(R.id.textView1);
        lm= (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        MyLocationListener ll=new MyLocationListener();
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,ll);
        //0,0- even if time changes or location changes the code works perfectly. but battery drain is alot - time,distance


    }
    class MyLocationListener implements LocationListener{

        @Override
        public void onLocationChanged(Location location) {
            String text="My current location is :\n LATITUDE"+location.getLatitude()+"\n Longitude: "+location.getLongitude();
            tv.setText(text);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {   //when we turn on the locationn
            Toast.makeText(getApplicationContext(),"GPS enabled",Toast.LENGTH_LONG).show();
            //this can be replaced by getApplocationCOntext() its the same
        }

        @Override
        public void onProviderDisabled(String provider) {
            Toast.makeText(getApplicationContext(),"GPS disabled",Toast.LENGTH_LONG).show();
        }
    }
}
