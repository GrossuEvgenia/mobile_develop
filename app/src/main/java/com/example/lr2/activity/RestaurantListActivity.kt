package com.example.lr2.activity

import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.example.lr2.R
import com.example.lr2.databinding.ActivityRestaurantListBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton


class RestaurantListActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityRestaurantListBinding

    var restaurantList = mutableListOf<Pair<LatLng, String>>() //список ресторанов (их координаты и адреса)
    private val markers = mutableListOf<Marker>()
    private var markerAddress: String = ""

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


        //показать маркер на карте по нажатию на элемент в списке c учётом фильтрации по поиску
        mListView.setOnItemClickListener(OnItemClickListener { _, _, position, _ ->
            val address = arrayAdapter.getItem(position)
            for (restaurant in restaurantList) {
                if(restaurant.second == address)
                {
                    val location = restaurant.first
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 16f))

                    for (marker in markers) {
                        if(location == marker.position)
                        {
                            marker.showInfoWindow()
                            markerAddress = address
                            break
                        }
                    }
                    break
                }
            }

        })

        var searchView = findViewById<SearchView>(R.id.map_search)
        //поиск по списку
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // on below line we are checking
                // if query exist or not.
                if (restaurantList.flatMap { (x, y) -> listOf(y) }.contains(query)) {
                    // if query exist within list we
                    // are filtering our list adapter.
                    arrayAdapter.filter.filter(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // if query text is change in that case we
                // are filtering our adapter with
                // new text on below line.
                arrayAdapter.filter.filter(newText)
                return false
            }
        })

        val saveChoice: FloatingActionButton = findViewById(R.id.save_button)

        saveChoice.setOnClickListener {

            //Сохранить выбранный адрес
            val sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("currentRestaurantAddress", markerAddress)
            editor.apply()
            finish()
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        //добавить маркеры ресторанов на карту
        for (location in restaurantList) {
            markers.add(mMap.addMarker(MarkerOptions().position(location.first).title(location.second))!!)
        }

        val sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE)
        var currentRestaurantAddressText = sharedPreferences.getString("currentRestaurantAddress", "")

        //выделить на карте выбранный ранее ресторан
        for (restaurant in restaurantList) {
            if(restaurant.second == currentRestaurantAddressText)
            {
                val location = restaurant.first
                for (marker in markers) {
                    if(location == marker.position)
                    {
                        val defaultZoom = 14.8f
                        marker.showInfoWindow()
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, defaultZoom))
                        markerAddress = currentRestaurantAddressText
                        break
                    }
                }
                break
            }
        }

        
    }
}