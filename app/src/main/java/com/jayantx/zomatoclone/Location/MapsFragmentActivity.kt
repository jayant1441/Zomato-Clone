package com.jayantx.zomatoclone.Location

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.jayantx.zomatoclone.R

class MapsFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps_fragment)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.google_map_fragment) as SupportMapFragment

        val LatLong = LatLng(SearchLocation().latitude.toDouble(), SearchLocation().longitude.toDouble())

        mapFragment.getMapAsync(OnMapReadyCallback {
            it.isMyLocationEnabled = true
            if (it.isMyLocationEnabled){
                it.addMarker(MarkerOptions().position(LatLong).title("my location"))
                it.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLong,13f))
            }

        })
    }
}
