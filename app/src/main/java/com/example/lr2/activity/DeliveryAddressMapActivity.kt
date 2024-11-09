package com.example.lr2.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.lr2.R
import com.example.lr2.activity.personinfo.FillAdressActivity
import com.example.lr2.databinding.ActivityDeliveryAddressMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DeliveryAddressMapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityDeliveryAddressMapBinding

    var myLocation = Pair<LatLng, String>(LatLng(53.34569, 83.7816), "Ленина, 46") //моё местоположение (координаты и адрес)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDeliveryAddressMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var actionBar = getSupportActionBar()
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back_vector);
            actionBar.setTitle("Выбрать адрес на карте")
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val saveChoice: FloatingActionButton = findViewById(R.id.save_button)

        saveChoice.setOnClickListener {
            //TODO Сохранить выбранный адрес
            finish()
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.addMarker(MarkerOptions().position(myLocation.first).title(myLocation.second))

        val defaultZoom = 15.0f
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation.first, defaultZoom))
    }
}