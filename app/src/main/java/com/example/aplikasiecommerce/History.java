package com.example.aplikasiecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.history);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Kemeja One Piece","Tanggal Pembelian : 10 April 2023","Total Harga : Rp 165.000",R.drawable.produk1));
        items.add(new Item("Earphone Bluetooth","Tanggal Pembelian : 1 Maret 2023","Total Harga : Rp 230.000",R.drawable.produk2));
        items.add(new Item("Kalung Pria","Tanggal Pembelian : 17 Februari 2023","Total Harga : Rp 125.000",R.drawable.produk3));
        items.add(new Item("Jam Tangan Fossil","Tanggal Pembelian : 1 Januari 2023","Total Harga : Rp 1.518.000",R.drawable.produk4));
        items.add(new Item("Keyboard Mechanical","Tanggal Pembelian : 25 Desember 2023","Total Harga : Rp 1.210.000",R.drawable.produk5));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items));

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.menu_history);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.menu_dashboard) {
                    Intent homeIntent = new Intent(History.this, Dashboard.class);
                    startActivity(homeIntent);
                    return true;
                } else if (itemId == R.id.menu_loc) {
                    Intent locIntent = new Intent(History.this, Location.class);
                    startActivity(locIntent);
                    return true;
                }

                return false;
            }
        });

    }
}