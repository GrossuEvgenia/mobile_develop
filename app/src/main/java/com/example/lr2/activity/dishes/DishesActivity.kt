package com.example.lr2.activity.dishes
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lr2.R
import com.example.lr2.adapters.DishesAdapter
import com.example.lr2.apiclient.apis.DishApi

class DishesActivity : AppCompatActivity() {

    lateinit var dishCategoryNameTV: TextView
    lateinit var dishesRCV: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dishes_layout)

        //получение и вывод атрибутов категории блюд
        var dishCategoryID = intent.getIntExtra("dish_category_id", -1)
        val dishCategoryName = intent.getStringExtra("dish_category_name")
        dishCategoryNameTV = findViewById(R.id.dishTVTittle)
        dishCategoryNameTV.text = dishCategoryName

        dishesRCV = findViewById(R.id.DishesRCV)
        StrictMode.setThreadPolicy(ThreadPolicy.Builder().permitAll().build())
        val api = DishApi()
        dishesRCV.adapter = DishesAdapter(api.getDishes(dishCategoryID), this)
        dishesRCV.hasFixedSize()
        dishesRCV.layoutManager = LinearLayoutManager(this)

        //настройка top app bar
        val actionBar = getSupportActionBar()
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back_vector);
            actionBar.setTitle(dishCategoryName)
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}