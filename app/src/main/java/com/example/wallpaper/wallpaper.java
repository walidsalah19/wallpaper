package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import static android.provider.MediaStore.Images.Media.getBitmap;

public class wallpaper extends AppCompatActivity {
   String api="563492ad6f9170000100000137ed4840393a4e37bc9084fe842dc2be";
   Button btn;
   ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final WallpaperManager wall=WallpaperManager.getInstance(getApplicationContext());
        btn=findViewById(R.id.set_wallpaper);
        image=findViewById(R.id.image_wallpaper);
        Intent intent = getIntent();
        Glide.with(this).load(intent.getStringExtra("image")).into(image);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
                    wall.setBitmap(bitmap);

                }catch (Exception e) {

                }
            }
        });
    }
}