package com.example.lr2.activity.dishscreen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.lr2.R
import com.example.lr2.activity.MainActivity
import com.example.lr2.ui.cart.CartFragment

/***
 * Класс активности для экрана с блюдом, наверное
 */

class DishScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dish_screen)
    }

    fun backFromDish(view: View){
        val backFromDishIntent = Intent(this, MainActivity::class.java)
        startActivity(backFromDishIntent)
    }

    fun cartFromDish (view: View){
        val cartFromDishIntent = Intent(this, CartFragment::class.java)
        startActivity(cartFromDishIntent)
    }

}

class dishSauceAdapter(private val sauce: List<String>){
    class dishSauceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dishImageView: View = itemView.findViewById(R.id.sauceImage)
    }
}