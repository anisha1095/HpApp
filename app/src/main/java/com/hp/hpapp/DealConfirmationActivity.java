package com.hp.hpapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DealConfirmationActivity extends AppCompatActivity {
    TextView tv1,tv2;
    String ans="Unanswered";
    void showToast(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }//end of showToast() method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal_confirmation);
        tv1=(TextView)findViewById(R.id.textView1);
        tv2=(TextView)findViewById(R.id.textView2);

        Intent intent=getIntent();
        tv1.append(intent.getStringExtra("Q"));
        tv2.append(intent.getStringExtra("P"));


    }//end of onCreate

    public void check(View v){
        int bid=v.getId();
        switch(bid){
            case R.id.button1: ans="Deal Accepted";
                               break;
            case R.id.button2: ans="Deal Rejected";
                               break;
        }//end of switch
        Intent intent=new Intent();
        intent.putExtra("A",ans);
        setResult(999,intent);   //999: response code
        finish();
    }
}//end of dealconfirmation
