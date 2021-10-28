package com.example.azkeral_moslam;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adepterpraytime extends RecyclerView.Adapter<adepterpraytime.praytimesviewholder> {
    private ArrayList<itempraytimes> itempray= new ArrayList<>();

    public adepterpraytime(ArrayList<itempraytimes> itempray) {
        this.itempray = itempray;
    }

    public class  praytimesviewholder extends RecyclerView.ViewHolder{
        TextView prayname,praytime;
        ImageView prayimage;
        Color praycolor;
        public praytimesviewholder(@NonNull  View itemView) {
            super(itemView);
            prayname= itemView.findViewById(R.id.prayname);
            praytime= itemView.findViewById(R.id.praytime);
            prayimage = itemView.findViewById(R.id.prayimage);

        }
    }

    @NonNull

    @Override
    public praytimesviewholder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new praytimesviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.praytimeitem, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull adepterpraytime.praytimesviewholder holder, int position) {
        itempraytimes item = itempray.get(position);
           holder.prayname.setText(item.getPrayname());
           holder.praytime.setText(item.getPraytime());
           holder.prayimage.setImageResource(item.prayimage);
    }

    @Override
    public int getItemCount() {
        return itempray.size();
    }
}
