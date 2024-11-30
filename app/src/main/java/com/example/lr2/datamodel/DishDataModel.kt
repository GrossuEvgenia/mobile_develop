package com.example.lr2.datamodel


/***
 * Класс с данными для категории блюд
 */
data class DishDataModel (
    var idCategory : Int,  // Категория блюда
    var idDish : Int,  // id (лучше UUID)
    var name : String,  // название
    var idImage : Int,  // id картинки
    var price : Int,  // цена
    var description : String,  // Описание
    var compose : String  // Состав
) : java.io.Serializable