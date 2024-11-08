package com.example.lr2.activity.personinfo

import android.os.Bundle
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
    }
}