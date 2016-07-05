package com.hp.hpapp;

import android.app.ListActivity;
import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.lang.reflect.Array;
import java.util.List;

public class CustomListActivity extends ListActivity {
    String[] fruits = {"Mango", "Apples", "Guava", "Cherry", "Strawberry", "Banana"};
    String[] desc = {"for shakes", "for dry fruits", "for decoration", "A common fruit", "for decoration", "king of fruits"};
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter adpt = null;
        adpt = new MyAdapter(this, android.R.layout.simple_list_item_1, fruits);
        setListAdapter(adpt);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "CustomList Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.hp.hpapp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "CustomList Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.hp.hpapp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    class MyAdapter extends ArrayAdapter    //making own adapter and inflating out single theme file. we tell the os 1. which theme file and apply on what array of elements
    {
        public MyAdapter(Context context, int resource, String[] array) //make this using alt+enter (3rd option)
        {
            super(context, resource, array);
        }

        //inflating single row file and fill with array
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater li = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);//end     to design custom list
            View row = li.inflate(R.layout.activity_custom_list, parent, false);
            ImageView iv= (ImageView) row.findViewById(R.id.imageView1);
            TextView tv1= (TextView) row.findViewById(R.id.textView1);
            TextView tv2= (TextView) row.findViewById(R.id.textView2);

            tv1.setText(fruits[position]);
            tv2.setText(desc[position]);

            if(position%2==0){
                iv.setImageResource(android.R.drawable.btn_star_big_on);

            }
            else
                iv.setImageResource(android.R.drawable.btn_star_big_off);
            return row;

        }
    }//end of myadapter

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(this,fruits[position],Toast.LENGTH_LONG).show();
    }
}
