package com.hp.hpapp;

//import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageResourceActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_resource);
        try {
            imageView = (ImageView) findViewById(R.id.imageView1);
            imageView.setImageResource(R.drawable.image);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
