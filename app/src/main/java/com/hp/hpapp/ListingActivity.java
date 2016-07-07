package com.hp.hpapp;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListingActivity extends ListActivity
{
    String screens[]={"MainActivity","LoginActivity","CompatibilityActivity","IntentDemoActivity","SpinnerActivity","RadioActivity","DealActivity",
            "CameraActivity","AlertDialogActivity","ListInDialogActivity","ImageResourceActivity","OptionMenuActivity","SharedPreferencesActivity",
            "SeekBarActivity","ProgressBarActivity","CustomListActivity","SplashActivity","SDcardActivity",
            "DatabaseActivity","DynamicListActivity","BluetoothActivity","Bluetooth2Activity","ProximitySensorActivity","OrientationSensorActivity",
            "GPSActivity","MyBroadcastReciever1","ServiceActivity","MusicActivity","WallpaperActivity","WifiActivity","","EXIT"};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,screens);
        setListAdapter(adapter);


    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Toast.makeText(this,screens[position],Toast.LENGTH_SHORT).show();

        if(screens[position].equals("EXIT"))
        {
            finish();
        }
        else{
            String str="com.hp.hpapp"+"."+screens[position];
            try {
                Class c = Class.forName(str);

                Intent intent = new Intent(this, c);
                startActivity(intent);

            }catch(Exception e){
                Toast.makeText(this,"Screen not yet designed",Toast.LENGTH_LONG).show();
            }


        }
    }
}
