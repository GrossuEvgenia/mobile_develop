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

            val dish1 = DishInfo()
            dish1.dishName = "Цезарь"
            dish1.dishImagePath = "toDo"
            dish1.weight = 300
            dish1.ingredients = "Лаваш, филе цыплёнка, соус на выбор, огурец, томаты, сыр моцарелла, капуста, картофель фри."
            dish1.sauceImagePath = "toDo"

            val dish2 = DishInfo()
            dish2.dishName = "Гавайская"
            dish2.dishImagePath = "toDo"
            dish2.weight = 300
            dish2.ingredients = "Лаваш, филе цыплёнка, соус на выбор, капуста, ананас, сыр моцарелла."
            dish2.sauceImagePath = "toDo"

    }

    fun backFromDish(view: View){
        val backFromDishIntent = Intent(this, MainActivity::class.java)
        startActivity(backFromDishIntent)
    }

    fun cartFromDish (view: View){
        val cartFromDishIntent = Intent(this, CartFragment::class.java)
        startActivity(cartFromDishIntent)
    }


    class DishInfo {
        var dishImagePath: String? = null
        var dishName: String? = null
        var ingredients: String? = null
        var weight: Int = 0
        var sauceImagePath: String? = null
    }

   /* fun  dishesList(){
        val dish1 = DishInfo()
        dish1.dishName = "Цезарь"
        dish1.dishImagePath = "toDo"
        dish1.weight = 300
        dish1.ingredients = "Лаваш, филе цыплёнка, соус на выбор, огурец, томаты, сыр моцарелла, капуста, картофель фри."
        dish1.sauceImagePath = "toDo"

        val dish2 = DishInfo()
        dish2.dishName = "Гавайская"
        dish2.dishImagePath = "toDo"
        dish2.weight = 300
        dish2.ingredients = "Лаваш, филе цыплёнка, соус на выбор, капуста, ананас, сыр моцарелла."
        dish2.sauceImagePath = "toDo"
    } */
}
/*class dishSauceAdapter(private val sauce: List<String>){
    class dishSauceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dishImageView: View = itemView.findViewById(R.id.sauceImage)
    }

}*/