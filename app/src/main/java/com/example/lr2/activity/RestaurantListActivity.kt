package com.example.lr2.activity

import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lr2.R
import com.example.lr2.databinding.ActivityRestaurantListBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class RestaurantListActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityRestaurantListBinding

    var restaurantList = mutableListOf<Pair<LatLng, String>>() //список ресторанов (их координаты и адреса)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRestaurantListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var actionBar = getSupportActionBar()
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back_vector);
            actionBar.setTitle("Рестораны")
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // TODO Временно задаваемые в коде координаты и адреса ресторанов. Должны быть получены через API
        restaurantList.add(Pair(LatLng(53.34395,83.78078), "ул Ленина, 47"))
        restaurantList.add(Pair(LatLng(53.34633, 83.78773), "пр-т Комсомольский, 102"))
        restaurantList.add(Pair(LatLng(53.342558, 83.768451), "ул Крупской, 91"))
        restaurantList.add(Pair(LatLng(53.337603, 83.773561), "пр-т Красноармейский, 61"))
        restaurantList.add(Pair(LatLng(53.34975, 83.76375), "пр-т Социалистический, 130"))

        val arrayAdapter: ArrayAdapter<*>

        // access the listView from xml file
        var mListView = findViewById<ListView>(R.id.restaurant_listview)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, restaurantList.flatMap { (x, y) -> listOf(y) }) //получить адреса из списка ресторанов
        mListView.adapter = arrayAdapter

        //показать маркер на карте по нажатию на элемент в списке
        mListView.setOnItemClickListener(OnItemClickListener { _, _, position, _ ->
            val location = restaurantList[position].first
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 16f))
        })
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        for (location in restaurantList) {
            mMap.addMarker(MarkerOptions().position(location.first).title(location.second))
        }
        val defaultZoom = 14.8f
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(restaurantList[0].first, defaultZoom))
    }
}