package com.example.lr2.logic

import com.example.lr2.datamodel.CartItemModel
import com.example.lr2.datamodel.DishDataModel

object CartManager {
    private val cartItems = mutableListOf<CartItemModel>()

    fun addItem(dish: DishDataModel) {
        val existing = cartItems.find { it.dish == dish }
        if (existing != null) {
            existing.quantity++
        } else {
            cartItems.add(CartItemModel(dish))
        }
    }

    fun getItems(): List<CartItemModel> = cartItems.toList()

    fun clear() {
        cartItems.clear()
    }

    fun updateItemQuantity(dish: DishDataModel, change: Int) {
        val item = cartItems.find { it.dish == dish } ?: return
        item.quantity += change
        if (item.quantity <= 0) cartItems.remove(item)
    }
}