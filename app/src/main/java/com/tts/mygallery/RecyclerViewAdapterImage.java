package com.tts.mygallery;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RecyclerViewAdapterImage extends RecyclerView.Adapter<RecyclerViewAdapterImage.ViewHolder>{

    List<FilePOJO> list;
    private LayoutInflater mInflater;
    Context context;
    public RecyclerViewAdapterImage(Context context, List<FilePOJO> list) {
        this.list = list;
        this.mInflater = LayoutInflater.from(context);
        this.context =context;

    }

    @NonNull
    @Override
    public RecyclerViewAdapterImage.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.recyclerview_row_image, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterImage.ViewHolder viewHolder, int i) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

        final FilePOJO items=list.get(i);
        viewHolder.name.setText(items.getFileName());
        viewHolder.date.setText( formatter.format(items.getLastEditDate()).toString());
        Picasso.get().load(items.getFileImage()).placeholder(R.drawable.folder_img).into(viewHolder.imageView);
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context,ImageViewActivity.class);
                intent.putExtra("path",items.getFileImage().toString());
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
        TextView name,date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.tv_name);
            date= itemView.findViewById(R.id.tv_date);
            imageView =itemView.findViewById(R.id.imageView);
        }
    }
}

