package com.example.lr2.datamodel

/***
 * Класс с данными для категории блюд
 */
data class DishDataModel (
    var idDish : Int,  // id (лучше UUID)
    var name : String,  // название
    var image : Byte,  // картинка
    var price : Float,  // цена
    var description : String,  // Описание
    var category : DishCategoryDataModel,  // Категория блюда
    var compose : ArrayList<String>  // Состав
) : java.io.Serializable