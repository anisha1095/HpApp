package com.hp.hpapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CameraActivity extends AppCompatActivity
{
  ImageView imageView;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        imageView=(ImageView)findViewById(R.id.imageView1);
        btn=(Button)findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);    //using the camera hardware: address of camera
                startActivityForResult(intent,0);   //we'll return the image back to our page.(bitmap)
            }
        });//end of statement
    }//end of onCreate

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent dataIntent) {
        super.onActivityResult(requestCode, resultCode, dataIntent);

        Bundle bundel=dataIntent.getExtras();
        Bitmap bitmap=(Bitmap)bundel.get("data");   //format of image - extracting from bundle.
        imageView.setImageBitmap(bitmap);             //setting in imageView
    }
}
