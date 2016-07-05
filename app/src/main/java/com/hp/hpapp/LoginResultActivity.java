package com.hp.hpapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoginResultActivity extends AppCompatActivity {

    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_result);

        textView1 = (TextView) findViewById(R.id.textView1);
        Intent intent = getIntent();

        String u = intent.getStringExtra("USER");
        String p = intent.getStringExtra("PASS");

        textView1.setText("UserName: " + u);
        textView1.append("\nPassword: " + p);

        if (u.equals("anishajauhari") && p.equals("user123")) {
            textView1.append("\n \nLogin Authentication Successfully");
        } else {
            textView1.append("\n \nLogin Authentication failed");
        }

    }
}