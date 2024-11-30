package com.example.lr2.adapters
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.lr2.R
import com.example.lr2.activity.dishes.DishesActivity
import com.example.lr2.datamodel.DishCategoryDataModel

class DishCategoryAdapter(dishCategoryListParam: ArrayList<DishCategoryDataModel>, contextParam: Context) :
    RecyclerView.Adapter<DishCategoryAdapter.ViewHolder>() {
        var dishCategoryList = dishCategoryListParam
        var context = contextParam


        class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
            val dishCategoryItemName = view.findViewById<TextView>(R.id.dishCategoryItemNameTV)
            val dishCategoryItemImage = view.findViewById<ImageView>(R.id.dishCategoryItemImage)
            fun bind(dishCategoryData : DishCategoryDataModel, context : Context) {
                dishCategoryItemName.text = dishCategoryData.name
                dishCategoryItemImage.setImageResource(dishCategoryData.image_id)
                itemView.setOnClickListener(){
                    // Todo: Переход на новую страницу с нужной категорией блюд
                    Toast.makeText(context, "Pressed ${dishCategoryItemName.text}", Toast.LENGTH_SHORT).show()
                    val intent = Intent(context, DishesActivity::class.java).apply {
                        putExtra("dish_category_id", dishCategoryData.idDishCategory)
                        putExtra("dish_category_name", dishCategoryData.name)
                    }
                    context.startActivity(intent)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val inflater = LayoutInflater.from(context)
            return ViewHolder(inflater.inflate(R.layout.dish_category_item_layout, parent, false))
        }

        override fun getItemCount(): Int {
            return dishCategoryList.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val dishCategoryListItem = dishCategoryList.get(position)
            holder.bind(dishCategoryListItem, context)
        }
    }