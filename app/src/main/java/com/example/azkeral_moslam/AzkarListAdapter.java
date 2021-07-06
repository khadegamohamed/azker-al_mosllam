package com.example.azkeral_moslam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AzkarListAdapter extends RecyclerView.Adapter<AzkarListAdapter.AzkarViewHolder> {

    private ArrayList<imageazker> azkar;
    public AzkarListAdapter(ArrayList<imageazker> azkar) {
        this.azkar = azkar;
    }
    @NonNull
    @Override
    public AzkarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AzkarViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.itemofadepter, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AzkarViewHolder holder, int position) {
        holder.bind(azkar.get(position));
    }

    @Override
    public int getItemCount() {
        return azkar.size();
    }

    public class AzkarViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;

        public AzkarViewHolder(View item) {
            super(item);
            img=item.findViewById(R.id.azker_image);
            txt=item.findViewById(R.id.azker_text);
        }


        public void bind(imageazker azkarModel) {
            if (azkarModel.image != -1) {
                img.setVisibility(View.VISIBLE);
                img.setImageResource(azkarModel.getImage());
            }
            else {
                img.setVisibility(View.GONE);
            }
            txt.setText(azkarModel.getName());
        }
    }
}
