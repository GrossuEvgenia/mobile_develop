package com.example.lr2.activity.dishes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.lr2.R
import com.example.lr2.activity.personinfo.FillAdressActivity

class DishesActivity : AppCompatActivity() {

    lateinit var id_category_dish : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dishes_layout)
        //работа с полями на экране
        id_category_dish = findViewById(R.id.tv2)
        id_category_dish.text = intent.getIntExtra("dish_category_id", -1).toString()
        val CategoryText = intent.getStringExtra("dish_category_name")

        //настройка top app bar
        val actionBar = getSupportActionBar()
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back_vector);
            actionBar.setTitle(CategoryText)
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


    }
}