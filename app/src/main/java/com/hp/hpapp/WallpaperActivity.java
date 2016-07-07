package com.hp.hpapp;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class WallpaperActivity extends AppCompatActivity {
ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);
        iv= (ImageView) findViewById(R.id.imageView1);
    }
    public void setWall(View v){
        WallpaperManager wm=WallpaperManager.getInstance(getApplicationContext());
        //WallpaperManager wm=WallpaperManager.getInstance(Context.WALLPAPER_SERVICE);
        Drawable d=iv.getDrawable();
        BitmapDrawable bmd=(BitmapDrawable)d;
        Bitmap b=bmd.getBitmap();
        try{
            wm.setBitmap(b);

        }catch(Exception e){
            Toast.makeText(this,"Wallpaper not set",Toast.LENGTH_LONG).show();
        }

    }
}
