package com.example.lr2.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lr2.datamodel.CartItemModel
import com.example.lr2.logic.CartManager

class CartViewModel : ViewModel() {
    private val _items = MutableLiveData<List<CartItemModel>>()
    val items: LiveData<List<CartItemModel>> = _items

    fun refresh() {
        _items.value = CartManager.getItems()
    }

    fun changeQuantity(item: CartItemModel, change: Int) {
        CartManager.updateItemQuantity(item.dish, change)
        refresh()
    }
}