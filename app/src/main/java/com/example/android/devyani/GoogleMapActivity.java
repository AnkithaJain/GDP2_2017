package com.example.android.devyani;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String id1 = null;
    String id2 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);
        System.out.println("Map activity created");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng lib = new LatLng(40.353,  -94.885);
        LatLng colden = new LatLng(40.350, -94.882);
        LatLng rec = new LatLng(40.350, -94.885);
        LatLng bearcat = new LatLng(40.350,  -94.885);

        LatLng sydney = new LatLng(40.353,  -94.886);
        LatLng melbourne = new LatLng(40.350, -94.885);
        Marker m1 = mMap.addMarker(new MarkerOptions().position(lib).title("Library"));
       // mMap.addMarker(new MarkerOptions().position(lib).title("library"));

        Marker m2 = mMap.addMarker(new MarkerOptions().position(colden).title("Colden Hall"));
        mMap.addMarker(new MarkerOptions().position(colden).title("Colden Hall"));
//
       Marker m3 = mMap.addMarker(new MarkerOptions().position(rec).title("Rec Center"));
//        mMap.addMarker(new MarkerOptions().position(rec).title("Rec Center"));

//        Marker m4 = mMap.addMarker(new MarkerOptions().position(colden).title("Bearcat Stadium"));
//        mMap.addMarker(new MarkerOptions().position(bearcat).title("Bearcat Stadium"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(40.352611,-94.883933), 16.0f));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Intent parkinagAreaNameDetail = new Intent(GoogleMapActivity.this,ParkingAreaNameDetail.class);
                parkinagAreaNameDetail.putExtra("area",marker.getTitle());
                startActivity(parkinagAreaNameDetail);
                return false;
            }
        });

        id1 = m1.getId();
        System.out.println("Sydney ki id " +id1);
        id2 = m2.getId();

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                System.out.println("Inside marker clicked: " + marker.getId());
                if(marker.getId().equals("m0"))
                {

                    Intent intent = new Intent(GoogleMapActivity.this,ParkingAreasActivity.class);
                    startActivity(intent);
                }else
                {
                    if(marker.getId().equals("m2"))
                    {
                        Intent intent = new Intent(GoogleMapActivity.this,ParkingAreasActivity.class);
                        startActivity(intent);
                    }}
            }
        });
    }

}

