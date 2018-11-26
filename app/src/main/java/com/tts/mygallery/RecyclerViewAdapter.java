package com.tts.mygallery;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    List<FilePOJO> list;
    private LayoutInflater mInflater;
    Context context;
    public RecyclerViewAdapter(Context context, List<FilePOJO> list) {
        this.list = list;
        this.mInflater = LayoutInflater.from(context);
        this.context =context;

    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.recyclerview_row, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int i) {

        final FilePOJO items=list.get(i);
        File myDir = new File(Environment.getExternalStorageDirectory() + "/MyGallery/"+items.getFileName()+"/");
        File[] files =myDir.listFiles();

        viewHolder.count.setText(String.valueOf(files.length));
        viewHolder.name.setText(items.getFileName());
        Picasso.get().load(items.getFileImage()).placeholder(R.drawable.folder_img).into(viewHolder.imageView);
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context,ImageListActivity.class);
                intent.putExtra("path",items.getFileName());
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name,count;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.tv_name);
            count= itemView.findViewById(R.id.tv_count);
            imageView =itemView.findViewById(R.id.imageView);

        }
    }
}

