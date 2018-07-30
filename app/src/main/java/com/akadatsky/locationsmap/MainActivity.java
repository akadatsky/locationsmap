package com.akadatsky.locationsmap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);

        LatLng latLng = new LatLng(48.458677, 35.0424448);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Marker in Dnipro"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14.0f));
    }

    public void moveClick(View view) {
        LatLng latLng = new LatLng(48.494184, 35.0633142);
        mMap.clear();
        mMap.addMarker(new MarkerOptions().position(latLng).title("Marker in Dnipro"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12.0f));
    }
}
