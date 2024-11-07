package com.example.lr2.activity.personinfo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.lr2.R

/***
 * Класс активити для истории заказов
 */
class OrderStoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_order_activity)
        var actionBar = getSupportActionBar()

        //настройка top app bar
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back_vector);
            actionBar.setTitle("История заказов")
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        val addAddrOnCart : Button = findViewById(R.id.addAddrOnCart)

        addAddrOnCart.setOnClickListener {
            val intent = Intent(this, DeliveryAddressMapActivity::class.java)
            startActivity(intent)
        }
    }
}