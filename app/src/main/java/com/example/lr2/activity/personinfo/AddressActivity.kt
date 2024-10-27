package com.example.lr2.activity.personinfo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.lr2.R

/***
 * Класс активности для экрана с адресом
 */
class AddressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_address)

        //настройка top app bar
        var actionBar = getSupportActionBar()
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back_vector);
            actionBar.setTitle("Адреса доставки")
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        //переход по кнопке на экран с заполнением адреса
        val addDddress: Button = findViewById(R.id.add)
        addDddress.setOnClickListener {
            val intent = Intent(this, FillAdressActivity::class.java)
            startActivity(intent);
        }
    }
}