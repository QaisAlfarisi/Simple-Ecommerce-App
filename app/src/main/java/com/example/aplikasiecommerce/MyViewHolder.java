package com.example.aplikasiecommerce;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView produkView,tanggalView, hargaView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
        produkView = itemView.findViewById(R.id.produk);
        tanggalView = itemView.findViewById(R.id.tanggal);
        hargaView = itemView.findViewById(R.id.harga);
    }
}
