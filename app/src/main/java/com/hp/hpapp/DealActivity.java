package com.hp.hpapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DealActivity extends AppCompatActivity
{
    EditText et1,et2;
    void showToast(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }//end of showToast() method
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal);
        et1= (EditText) findViewById(R.id.editText1);
        et2= (EditText) findViewById(R.id.editText2);


    }//end of onCreate() method

    public void calculate(View v)
    {
        String quantity=et1.getText().toString();  //recieve as string
        String price=et2.getText().toString();   //recive as string

        //transferring control from one screen to other. with 2 radio buttons and we have to come back to this screen with the result
        Intent intent =new Intent(this, DealConfirmationActivity.class);
        intent.putExtra("Q",quantity);
        intent.putExtra("P",price);
        startActivityForResult(intent,1007); //1007: dummy number , this number is returned with the result use?
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {  //requestCode=1007 resultCode=999 data=ans
        super.onActivityResult(requestCode, resultCode, data);
        String res=data.getStringExtra("A");
        showToast(res);

    }//end of method
}//end of DealActivity
