package com.hp.hpapp;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class IntentDemoActivity extends ListActivity {
   String screens[]={"PHONE CALL","SMS","WEB BROWSING","WEB SEARCH","PHONE BOOK","MAP","EXIT"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,screens);
        setListAdapter(adapter);


    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        if(screens[position].equals("EXIT"))
        {
            finish();
        }
        else if(screens[position].equals("PHONE CALL")){
            Intent i=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9810817666"));
            startActivity(i);
        }
        else if(screens[position].equals("SMS")){
            Intent i=new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:9810817666"));
            i.putExtra("sms_body","hey dad!!!");
            startActivity(i);
        }
        else if(screens[position].equals("WEB BROWSING")){
            Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
            startActivity(i);
        }
        else if(screens[position].equals("WEB SEARCH")){
            Intent i=new Intent(Intent.ACTION_WEB_SEARCH);

            i.putExtra(SearchManager.QUERY,"android apps");
            startActivity(i);
        }
        else if(screens[position].equals("PHONE BOOK")){
            Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people/"));
            startActivity(i);
        }
        else if(screens[position].equals("MAP")){
            Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.7749,-122.4194"));
            startActivity(i);
        }

    }
}
