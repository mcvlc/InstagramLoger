package com.project.darkhorsestd.instagramloger.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.project.darkhorsestd.instagramloger.R;
import com.project.darkhorsestd.instagramloger.data.managers.DataManager;

import java.util.List;




public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

        private GoogleMap mMap;
        private DataManager mDataManager = DataManager.getInstance();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_maps);

            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }

        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;

            List<Float> photoLatitude = mDataManager.getPreferencesManager().getLatitude();
            List<Float> photoLongitude = mDataManager.getPreferencesManager().getLongitude();

            for(int i = 0; i < photoLatitude.size();i++){
                mMap.addMarker(new MarkerOptions().position(new LatLng(photoLatitude.get(i),photoLongitude.get(i))));
                if(i == photoLatitude.size()-1){
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(photoLatitude.get(i),photoLongitude.get(i))));
                }
            }
        }
    }


