package com.example.wallpaper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wallpaper.gson_class.gson_class;

import java.util.List;

import retrofit2.http.Url;

public class recycler_adapter extends RecyclerView.Adapter<recycler_adapter.recycler>{
    List <gson_class> list;
    Context context;

    public recycler_adapter(List<gson_class> list, android.content.Context context) {
        this.list = list;
        this.context=context;
    }

    @NonNull
    @Override
    public recycler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new recycler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recycler holder, int position) {
           holder.text.setText(list.get(position).getPhotographer());
            holder.text.setMovementMethod(LinkMovementMethod.getInstance());
            holder.text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent  intent =new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.pexels.com/"));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
            Glide.with(context).load(list.get(position).getSrc().getPortrait()).into(holder.image);
            holder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,wallpaper.class);
                    intent.putExtra("image",list.get(position).getSrc().getPortrait());
                    context.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class recycler extends RecyclerView.ViewHolder
    {
        ImageView image;
        TextView text;
        public recycler(@NonNull View itemView) {
            super(itemView);
            image=(ImageView) itemView.findViewById(R.id.image_item);
            text=(TextView) itemView.findViewById(R.id.text_item);
        }
    }
}
