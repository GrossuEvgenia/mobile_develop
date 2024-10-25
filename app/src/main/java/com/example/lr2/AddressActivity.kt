package com.example.lr2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AddressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_address)

        var actionBar = getSupportActionBar()

        // showing the back button in action bar
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back_vector);
            actionBar.setTitle("Адреса доставки")
            // showing the back button in action bar
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        val addDddress : Button = findViewById(R.id.add)
        addDddress.setOnClickListener {
            val intent = Intent(this, FillAdressActivity::class.java)
            startActivity(intent);
        }
    }
}