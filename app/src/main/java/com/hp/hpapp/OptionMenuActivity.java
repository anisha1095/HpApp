package com.hp.hpapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class OptionMenuActivity extends AppCompatActivity
{
    void showToast(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }//end of showToast() method
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);

    }//end of onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_options_menu,menu);  //inflate xml(displaying graphic of xml)
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        switch(id){
            case R.id.item1: showToast("Add New");
                             break;
            case R.id.item2: showToast("View All");
                             break;
            case R.id.item3: showToast("Update");
                             break;
            case R.id.item4: showToast("Settings");
                             break;
        }
        return super.onOptionsItemSelected(item);
    }
}//end of OptionMenuActivity
