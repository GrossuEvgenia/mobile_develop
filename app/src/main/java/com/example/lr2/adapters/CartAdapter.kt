package com.example.lr2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lr2.R
import com.example.lr2.datamodel.CartItemModel
import com.example.lr2.ui.cart.CartViewModel

class CartAdapter(
    private var items: List<CartItemModel>,
    private val viewModel: CartViewModel
) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name: TextView = view.findViewById(R.id.itemName)
        private val price: TextView = view.findViewById(R.id.itemPrice)
        private val quantity: TextView = view.findViewById(R.id.quantityText)
        private val minus: ImageView = view.findViewById(R.id.decreaseBtn)
        private val plus: ImageView = view.findViewById(R.id.increaseBtn)
        private val image: ImageView = view.findViewById(R.id.itemImage)

        fun bind(item: CartItemModel) {
            name.text = item.dish.name
            price.text = "${item.dish.price} ₽"
            quantity.text = item.quantity.toString()
            image.setImageResource(item.dish.idImage)

            minus.setOnClickListener { viewModel.changeQuantity(item, -1) }
            plus.setOnClickListener { viewModel.changeQuantity(item, 1) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cart_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun updateItems(newItems: List<CartItemModel>) {
        items = newItems
        notifyDataSetChanged()
    }
}