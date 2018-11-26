package com.tts.mygallery;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;

public class ImageListActivity extends AppCompatActivity {

    ArrayList<FilePOJO> list = new ArrayList<>();
    RecyclerViewAdapterImage recyclerViewAdapter;
    RecyclerView recyclerView;
    File myDir;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);

        String path =getIntent().getStringExtra("path");
        myDir = new File(Environment.getExternalStorageDirectory() + "/MyGallery/"+path);

        recyclerView = findViewById(R.id.recView);
        recyclerViewAdapter =new RecyclerViewAdapterImage(this,list);



        displayImages();


        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(recyclerViewAdapter);


    }

    private void displayImages() {

        list.clear();
        File[] files =myDir.listFiles();
        FilePOJO filePOJO;
        if (myDir.isDirectory()){
            for(File singleFile : files){
                filePOJO =new FilePOJO();
                filePOJO.setFileImage(Uri.fromFile(singleFile));
                filePOJO.setLastEditDate(singleFile.lastModified());
                filePOJO.setFileName(singleFile.getName());

                list.add(filePOJO);

                recyclerViewAdapter.notifyDataSetChanged();
            }

        }

    }
}
