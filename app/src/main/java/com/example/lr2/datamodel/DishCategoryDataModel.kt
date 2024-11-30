package com.example.lr2.datamodel

/***
 * Класс с данными для категории блюд
 */
data class DishCategoryDataModel (
    var idDishCategory : Int,  // id (лучше UUID)
    var name : String,  // название
    var image_id : Int  // id картинки
) : java.io.Serializable