package com.tts.mygallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class ImageViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        String path =getIntent().getStringExtra("path");


        ImageView imageView =findViewById(R.id.imageView);
        Picasso.get().load(path).placeholder(R.drawable.folder_img).into(imageView);

    }
}
