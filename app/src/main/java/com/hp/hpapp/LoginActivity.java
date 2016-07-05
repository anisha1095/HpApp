package com.hp.hpapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText1=(EditText)findViewById(R.id.editText1);
        editText2=(EditText)findViewById(R.id.editText2);
    }

    public void show(View v) {
        String s1=editText1.getText().toString();
        String s2=editText2.getText().toString();
        Intent intent = new Intent(LoginActivity.this, LoginResultActivity.class);
        intent.putExtra("USER",s1);
        intent.putExtra("PASS",s2);
        startActivity(intent);
    }

}
