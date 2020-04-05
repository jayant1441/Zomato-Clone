package com.jayantx.zomatoclone.Location

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.jayantx.zomatoclone.R


class SearchLocation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_location)

//        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        val mapFragment = supportFragmentManager.findFragmentById(R.id.google_map_fragment) as SupportMapFragment

        mapFragment.getMapAsync(OnMapReadyCallback {
            if (it.isMyLocationEnabled){

            }

            it.addMarker(MarkerOptions().position(LatLng(71.0,77.0)).title("my location"))
        })
    }
}
