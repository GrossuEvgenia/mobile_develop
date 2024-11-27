package com.example.lr2.apicall

import com.example.lr2.R
import com.example.lr2.datamodel.DishCategoryDataModel

// ToDo: Класс-заглушка запросов, удалить после подключения API
class MockRequests {
    fun getDishCategory() : ArrayList<DishCategoryDataModel>{
        val listDishCategory = ArrayList<DishCategoryDataModel>()

        listDishCategory.add(DishCategoryDataModel(1, "Комбо", R.drawable.combo_image))
        listDishCategory.add(DishCategoryDataModel(2, "Шаурма", R.drawable.shava_image))
        listDishCategory.add(DishCategoryDataModel(3, "Пицца", R.drawable.pizza_image))
        listDishCategory.add(DishCategoryDataModel(4, "Фри", R.drawable.free_image))
        listDishCategory.add(DishCategoryDataModel(5, "Вок", R.drawable.wok_image))
        listDishCategory.add(DishCategoryDataModel(6, "Просто поесть", R.drawable.just_eat_image))
        listDishCategory.add(DishCategoryDataModel(7, "Роллы", R.drawable.rolls_image))
        listDishCategory.add(DishCategoryDataModel(8, "Напитки", R.drawable.drink_image))
        return listDishCategory
    }
}