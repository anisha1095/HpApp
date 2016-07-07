package com.hp.hpapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProximitySensorActivity extends AppCompatActivity implements SensorEventListener {
    ImageView iv;
    SensorManager sm;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_sensor);
        tv= (TextView) findViewById(R.id.textView1);
        iv= (ImageView) findViewById(R.id.imageView1);
        String ss= Context.SENSOR_SERVICE;
        sm= (SensorManager) getSystemService(ss);
        int type= Sensor.TYPE_PROXIMITY;
        Sensor s =sm.getDefaultSensor(type);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
        //iv.setImageResource(R.drawable.abc_btn_rating_star_off_mtrl_alpha);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.values[0]==0){
       iv.setImageResource(android.R.drawable.star_big_off);

        }
        else {
            iv.setImageResource(android.R.drawable.star_big_on);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    @Override
    protected void onStop() {
        super.onStop();
        sm.unregisterListener(this);

     }
}
