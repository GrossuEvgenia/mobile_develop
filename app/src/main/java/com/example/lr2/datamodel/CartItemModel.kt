package com.example.lr2.datamodel

data class CartItemModel(
    val dish: DishDataModel,
    var quantity: Int = 1
)