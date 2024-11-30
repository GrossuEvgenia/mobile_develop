package com.example.lr2.adapters
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.lr2.R
import com.example.lr2.datamodel.DishDataModel

class DishesAdapter(dishesListParam: ArrayList<DishDataModel>, contextParam: Context) :
    RecyclerView.Adapter<DishesAdapter.ViewHolder>() {
        var dishesList = dishesListParam
        var context = contextParam


        class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
            val dishItemImage = view.findViewById<ImageView>(R.id.dishItemImage)
            val dishNameItemTV = view.findViewById<TextView>(R.id.dishNameItemTV)
            val dishPriceItemTV = view.findViewById<TextView>(R.id.dishPriceItemTV)
            val dishDescriptionItemTV = view.findViewById<TextView>(R.id.dishDescriptionItemTV)
            val dishInCartItemBtn = view.findViewById<Button>(R.id.dishInCartItemBtn)
            fun bind(dishData : DishDataModel, context : Context) {

                dishNameItemTV.text = dishData.name
                dishPriceItemTV.text = "${dishData.price} ₽"
                dishDescriptionItemTV.text = dishData.description
                dishItemImage.setImageResource(dishData.idImage)

                itemView.setOnClickListener(){
                    Toast.makeText(context, "Go to ${dishNameItemTV.text}", Toast.LENGTH_SHORT).show()
                    // Todo: Переход на новую страницу с инфой о блюде
                    // Todo: Указать нужный activity и передаваемые параметры
//                    val intent = Intent(context, DishesActivity::class.java).apply {
//                        putExtra("dish_category_id", dishCategoryData.idDishCategory)
//                        putExtra("dish_category_name", dishCategoryData.name)
//                    }
//                    context.startActivity(intent)
//                val intent = Intent(activity, FillPersonDataParamsActivity::class.java)
//                intent.putExtra("id",123)
//                startActivity(intent)
                }
                dishInCartItemBtn.setOnClickListener(){
                    Toast.makeText(context, "Добавлено в корзину", Toast.LENGTH_SHORT).show()
                    // Todo: Реализация добавления в корзину блюда
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val inflater = LayoutInflater.from(context)
            return ViewHolder(inflater.inflate(R.layout.dishes_item_layout, parent, false))
        }

        override fun getItemCount(): Int {
            return dishesList.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val dishesListItem = dishesList.get(position)
            holder.bind(dishesListItem, context)
        }
    }