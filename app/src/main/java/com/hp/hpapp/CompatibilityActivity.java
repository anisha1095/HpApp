package com.hp.hpapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CompatibilityActivity extends AppCompatActivity {

    EditText editText1,editText2;
    TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compatibility);
        editText1=(EditText)findViewById(R.id.editText1);
        editText2=(EditText)findViewById(R.id.editText2);
        textView1= (TextView) findViewById(R.id.textView4);
    }

    public void show(View v){
        String s1=editText1.getText().toString();
        String s2=editText2.getText().toString();
        int k=0;
        for(int i=0;i<s1.length();i++)
            for(int j=0;j<s2.length();j++){
                if(s1.charAt(i)==s2.charAt(j))
                {
                    k++;
                }
            }
         k=k*10;
        String h="compatibility: "+k;
        textView1.setText(h);


    }
}
