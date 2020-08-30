package com.example.recyclops_app;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng r1 = new LatLng(25.654556, -100.287200);
        mMap.addMarker(new MarkerOptions().position(r1).title("Centro de reciclaje tec"));
        LatLng r2 = new LatLng(25.657699, -100.287417);
        mMap.addMarker(new MarkerOptions().position(r2).title("Centro de reciclaje tec"));
        LatLng r3 = new LatLng(25.660255, -100.310012);
        mMap.addMarker(new MarkerOptions().position(r3).title("Centro de reciclaje tec"));
        LatLng r4 = new LatLng(25.628675, -100.275776);
        mMap.addMarker(new MarkerOptions().position(r4).title("Centro de reciclaje tec"));
        LatLng r5 = new LatLng(25.666255, -100.296646);
        mMap.addMarker(new MarkerOptions().position(r5).title("Centro de reciclaje tec"));
        LatLng r6 = new LatLng(25.673358, -100.296881);
        mMap.addMarker(new MarkerOptions().position(r6).title("Centro de reciclaje tec"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(r1, 13));
    }
}