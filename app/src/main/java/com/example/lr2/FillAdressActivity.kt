package com.example.lr2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class FillAdressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_fill_address)
        var actionBar = getSupportActionBar()

        // showing the back button in action bar
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back_vector);
            actionBar.setTitle("Добавление адреса")
            // showing the back button in action bar
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

}