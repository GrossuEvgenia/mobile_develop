package com.example.lr2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lr2.databinding.ActivityDeliveryAddressMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class DeliveryAddressMapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityDeliveryAddressMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDeliveryAddressMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var actionBar = getSupportActionBar()

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back_vector);
            actionBar.setTitle("Выбрать адрес на карте")
            // showing the back button in action bar
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val myAddress = LatLng(53.34542, 83.78204)
        mMap.addMarker(MarkerOptions().position(myAddress).title("Ленина, 46"))

        val defaultZoom = 15.0f
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myAddress, defaultZoom))
    }
}