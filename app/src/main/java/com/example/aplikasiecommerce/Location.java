package com.example.aplikasiecommerce;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;
import java.util.List;

public class Location extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap myMap;

    private Geocoder geocoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.location);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.menu_loc);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.menu_dashboard) {
                    Intent homeIntent = new Intent(Location.this, Dashboard.class);
                    startActivity(homeIntent);
                    return true;
                } else if (itemId == R.id.menu_history) {
                    Intent historyIntent = new Intent(Location.this, History.class);
                    startActivity(historyIntent);
                    return true;
                }

                return false;
            }
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        myMap = googleMap;

        LatLng outletA = new LatLng(-6.915845285206341 , 107.58613438261567);
        LatLng outletB = new LatLng(-6.916319633556482  , 107.59370478791487);
        LatLng outletC = new LatLng(-6.912804868628957 , 107.59174141113208);


        myMap.addMarker(new MarkerOptions().position(outletA).title("Outlet A - Jln. Rajawali No 09"));
        myMap.addMarker(new MarkerOptions().position(outletB).title("Outlet B - Jln. Pasar Kaliki No 27"));
        myMap.addMarker(new MarkerOptions().position(outletC).title("Outlet C - Jln Dipatiukur No 01"));
        float zoomLevel = 15.0f; // This goes up to 21
        myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(outletB, zoomLevel));
    }

    private String getMarkerSnippet(LatLng latLng) {
        StringBuilder snippetBuilder = new StringBuilder();

        try {

            List<Address> addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
            if (!addresses.isEmpty()) {
                Address address = addresses.get(0);
                snippetBuilder.append(address.getAddressLine(0)).append("\n");
                snippetBuilder.append(address.getLocality()).append(", ");
                snippetBuilder.append(address.getAdminArea()).append(" ");
                snippetBuilder.append(address.getPostalCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return snippetBuilder.toString();
    }

}