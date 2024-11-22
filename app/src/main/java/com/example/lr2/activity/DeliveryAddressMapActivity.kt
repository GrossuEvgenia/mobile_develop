package com.example.lr2.activity

import android.location.Geocoder
import android.os.Bundle
import android.util.Pair
import androidx.appcompat.app.AppCompatActivity
import com.example.lr2.R
import com.example.lr2.databinding.ActivityDeliveryAddressMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Locale

@Suppress("DEPRECATION")
class DeliveryAddressMapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityDeliveryAddressMapBinding

    private var currentMarker: Marker? = null
    private var markerAddress: String = ""

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
            //Сохранить выбранный адрес
            val sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("currentDeliveryAddress", markerAddress)
            editor.apply()
            finish()
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val geocoder = Geocoder(this, Locale.getDefault())
        val sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE)
        var currentDeliveryAddressText = sharedPreferences.getString("currentDeliveryAddress", "")
        var currentDeliveryCoords = geocoder.getFromLocationName("Барнаул, $currentDeliveryAddressText", 1)
        var myLocation = Pair<LatLng, String>(
            currentDeliveryCoords?.get(0)?.let { LatLng(it.latitude, currentDeliveryCoords[0].longitude) }, currentDeliveryAddressText) //моё местоположение (координаты и адрес)

        currentMarker = mMap.addMarker(MarkerOptions().position(myLocation.first).title("Адрес").snippet(myLocation.second))
        currentMarker?.showInfoWindow()

        val defaultZoom = 15.0f
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation.first, defaultZoom))

        mMap.setOnMapClickListener { latLng ->
            // Очищаем предыдущий маркер, если нужно (опционально)
            currentMarker?.remove()

            markerAddress = getAddressFromLatLng(latLng)

            // Добавляем новый маркер в место нажатия
            val markerOptions = MarkerOptions()
                .position(latLng)
                .title("Адрес")
                .snippet(markerAddress)

            currentMarker = mMap.addMarker(markerOptions)
            currentMarker?.showInfoWindow()
        }
    }

    @Suppress("DEPRECATION")
    private fun getAddressFromLatLng(latLng: LatLng): String
    {
        var address = "адрес не найден"
        val geocoder = Geocoder(this, Locale.getDefault())
        try {
            // Получаем список адресов (может вернуть несколько)
            val addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1)
            if (addresses != null) {
                if (addresses.isNotEmpty()) {
                    // Получение строки адреса
                    address = addresses[0].thoroughfare + ", " + addresses[0].featureName
                }
            }
        }
        catch (e: Exception) {
            e.printStackTrace()
        }
        return address
    }
}