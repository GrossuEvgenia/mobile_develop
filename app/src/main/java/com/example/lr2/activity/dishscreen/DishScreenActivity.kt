package com.example.lr2.activity.dishscreen

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.lr2.R
import com.example.lr2.activity.MainActivity
import com.example.lr2.ui.cart.CartFragment
import kotlin.text.toInt

/***
 * Класс активности для экрана с блюдом, наверное
 */

class DishScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dish_screen)

        dish1.dishName = "Цезарь"
        dish1.dishImagePath = "toDo"
        dish1.weight = "300 г"
        dish1.ingredients = "Лаваш, филе цыплёнка, соус на выбор, огурец, томаты, сыр моцарелла, капуста, картофель фри."
        dish1.sauceImagePath = "toDo"

        dish2.dishName = "Гавайская"
        dish2.dishImagePath = "toDo"
        dish2.weight = "300 г"
        dish2.ingredients = "Лаваш, филе цыплёнка, соус на выбор, капуста, ананас, сыр моцарелла."
        dish2.sauceImagePath = "toDo"

        val textDishName: TextView = findViewById(R.id.textDishName)
        val textDishIngredients: TextView = findViewById(R.id.textDishIngredients)
        val textDishWeight: TextView = findViewById(R.id.textDishWeight)

        val imageDish: ImageView = findViewById(R.id.imageDish)

        if (currentDish == 1) {
            textDishName.text = dish1.dishName
            textDishIngredients.text = dish1.ingredients
            textDishWeight.text = dish1.weight

            imageDish.setImageResource(R.drawable.caesar)
        }
        else {
            textDishName.text = dish2.dishName
            textDishIngredients.text = dish2.ingredients
            textDishWeight.text = dish2.weight

            imageDish.setImageResource(R.drawable.hawaii)
        }
    }

    fun backFromDish(view: View){
        val backFromDishIntent = Intent(this, MainActivity::class.java)
        startActivity(backFromDishIntent)
    }

    fun cartFromDish (view: View){
        val cartFromDishIntent = Intent(this, CartFragment::class.java)
        startActivity(cartFromDishIntent)
    }

    fun sizeRadialCheck1(view: View){
        val textDishWeight: TextView = findViewById(R.id.textDishWeight)
        textDishWeight.text = "300 г"
    }
    fun sizeRadialCheck2(view: View){
        val textDishWeight: TextView = findViewById(R.id.textDishWeight)
        textDishWeight.text = "400 г"
    }
    fun sizeRadialCheck3(view: View){
        val textDishWeight: TextView = findViewById(R.id.textDishWeight)
        textDishWeight.text = "500 г"
    }

    fun decreaseCounter (view: View){
        val dishCounterText: TextView = findViewById(R.id.dishCounterText)
        var count = Integer.parseInt(dishCounterText.text.toString())
        count--
        if(count>0) {
            dishCounterText.text = count.toString()
        }
    }

    fun increaseCounter (view: View){
        val dishCounterText: TextView = findViewById(R.id.dishCounterText)
        var count = Integer.parseInt(dishCounterText.text.toString())
        count++
        if(count<50) {
            dishCounterText.text = count.toString()
        }
    }

    companion object {
        class DishInfo {
            var dishImagePath: String? = null
            var dishName: String? = null
            var ingredients: String? = null
            var weight: String? = null
            var sauceImagePath: String? = null
        }

        val dish1 = DishInfo()
        val dish2 = DishInfo()

        var currentDish:Int = 0
    }
}
