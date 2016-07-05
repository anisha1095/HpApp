package com.hp.hpapp;
//practical use of this templerun ojet, file can be edited.

import android.content.DialogInterface;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SDcardActivity extends AppCompatActivity {
    EditText et1, et2;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdcard);
        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        //View v;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File rootPath= Environment.getExternalStorageDirectory();
                File f=new File(rootPath,"ContactsData.txt");        //path and name combination
                if(f.exists()==false){
                    try{
                        f.createNewFile();
                        Toast.makeText(SDcardActivity.this,"FILE Created",Toast.LENGTH_LONG);
                    }catch(Exception e){}

                }

                try{
                    String dts=et1.getText().toString()+":"+et2.getText().toString()+"\n";
                    FileOutputStream fos=new FileOutputStream(f,true); //true: append mode false: overwrite . can use reader , writer io files too then we dont need to convert to byte format
                    fos.write(dts.getBytes());   //format : character . therefore we need to convert into byte format
                    Toast.makeText(SDcardActivity.this,"DATA SAVED",Toast.LENGTH_LONG);

                }catch(Exception e){}

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File rootPath = Environment.getExternalStorageDirectory();
                File f = new File(rootPath, "ContactsData.txt");        //path and name combination
                if (f.exists() == true) {
                    try {
                        FileInputStream fis = new FileInputStream(f);
                        String fd = "";
                        while (true) {
                            int a = fis.read();      //"a" stores UNICode , same as ASCII code.
                            if (a == -1)   //EOF reached, read() returns -1.
                            {
                                break;

                            }
                            fd = fd + (char) a;
                        }

                        Toast.makeText(SDcardActivity.this, fd, Toast.LENGTH_LONG);
                    } catch (Exception e) {
                        Log.d("PROBLEM", e.toString());     // will print only when connected to usb. shows in Log window on android studio. and PROblem is the name of the error
                    }


                }//end of if
                else {
                    Toast.makeText(SDcardActivity.this, "NO data", Toast.LENGTH_LONG);
                }

            }
        });
    }
 }


