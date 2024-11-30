package com.example.lr2.apicall

import com.example.lr2.R
import com.example.lr2.datamodel.DishCategoryDataModel
import com.example.lr2.datamodel.DishDataModel

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

    fun generate_combo(listDishes : ArrayList<DishDataModel>): ArrayList<DishDataModel> {
        listDishes.add(DishDataModel(1, 1, "Комбо сытное DUO", R.drawable.combo_sytnoe_duo, 999, "Для парочки любителей паназиатской кухни! Сытные сочные новинки хот-боулы, набор “Царский фри” с хрустящими закусками, а также напитком на выбор.", ""))
        listDishes.add(DishDataModel(1, 2, "Комбо КРАШик", R.drawable.combo_crashnik, 499, "Нет шансов остаться равнодушным к комбо \"КРАШик\". Сочный свежий хот-дог с ароматными чигетсами и картофелем фри.", ""))
        listDishes.add(DishDataModel(1, 3, "Комбо для друзей", R.drawable.combo_for_friends, 1599, "Собираетесь компанией из 4-6 человек?! Готовое решение для вас. Включает в себя вкусные хиты и новинку пицца итальянская Бургер.", ""))
        listDishes.add(DishDataModel(1, 4, "Комбо на завтрак", R.drawable.combo_on_breakfast, 999, "Нет проблем, если не успел позавтракать. Используй готовое решение.", ""))
        return listDishes
    }

    fun generate_shava(listDishes : ArrayList<DishDataModel>): ArrayList<DishDataModel> {
        listDishes.add(DishDataModel(2, 1, "Грибная", R.drawable.shava_mushroom, 300, "Лаваш, филе цыпленка, соус на выбор, шампиньоны, картофель фри, крымский лук.", ""))
        listDishes.add(DishDataModel(2, 2, "Цезарь", R.drawable.shava_caesar, 300, "Лаваш, филе цыпленка, соус на выбор, огурец, томаты, сыр моцарелла, капуста, картофель фри.", ""))
        listDishes.add(DishDataModel(2, 3, "Сырная", R.drawable.shava_cheese, 280, "Лаваш, филе цыпленка, томаты, сыр моцарелла, сыр чеддер, капуста, соус сырный.", ""))
        listDishes.add(DishDataModel(2, 4, "Грильяс домашний", R.drawable.shava_grilias_home, 280, "Пшеничная лепешка, филе цыпленка, капуста, картофель фри, лук фри, бекон, болгарский перец, соус “Сладкий черри”.", ""))
        listDishes.add(DishDataModel(2, 4, "Царская", R.drawable.shava_royal, 260, "Лаваш, филе цыпленка, соус на выбор, морковь по-корейски, капуста, томаты, огурец, картофель фри.", ""))
        return listDishes
    }

    fun generate_pizza(listDishes : ArrayList<DishDataModel>): ArrayList<DishDataModel> {
        listDishes.add(DishDataModel(3, 1, "Бургер", R.drawable.pizza_burger, 680, "Тесто, соус красный, сыр моцарелла, бекон, рубленное филе цыпленка в томатном соусе, огурцы маринованные, томаты, лук фри, соус гриль, орегано. Диаметр - 30 см.", ""))
        listDishes.add(DishDataModel(3, 2, "Жульен", R.drawable.pizza_julienne, 620, "Тесто, филе цыпленка, соус цезарь, шампиньоны жареные, лук крымский, лук фри, соус горчичный, орегано. Диаметр - 30 см.", ""))
        listDishes.add(DishDataModel(3, 3, "Морская", R.drawable.pizza_sea, 820, "Тесто, соус цезарь, соус том ям, сыр моцарелла, шампиньоны, креветки, томаты, орегано. Диаметр - 30 см.", ""))
        listDishes.add(DishDataModel(3, 4, "Сырная", R.drawable.pizza_cheese, 590, "Тесто, соус цезарь, сыр моцарелла, соус сырный, сыр пармезан, сыр чеддер, орегано. Диаметр - 30 см", ""))
        return listDishes
    }

    fun generate_free(listDishes : ArrayList<DishDataModel>): ArrayList<DishDataModel> {
        listDishes.add(DishDataModel(4, 1, "Картофель фри 100гр", R.drawable.free_free, 110, "Обжаренная до хрустящей корочки аппетитная картошка", ""))
        listDishes.add(DishDataModel(4, 2, "Крылья барбекю", R.drawable.free_barbeku, 390, "Порция из 5 или 9 сегментов крыла цыпленка в соусе барбекю.", ""))
        listDishes.add(DishDataModel(4, 3, "Хот-дог Жгучий", R.drawable.free_burning, 280, "Булочка, сосиска, салат айсберг, соус цезарь, огурцы маринованные, соус пикантный, соус горчичный, лук фри, перец халапеньо", ""))
        listDishes.add(DishDataModel(4, 4, "Хот-дог Классический", R.drawable.free_classic, 280, "Булочка, сосиска, салат айсберг, соус цезарь, огурцы маринованные, соус пикантный, соус горчичный, лук фри.", ""))
        return listDishes
    }

    fun generate_wok(listDishes : ArrayList<DishDataModel>): ArrayList<DishDataModel> {
        listDishes.add(DishDataModel(5, 1, "Терияки Рис", R.drawable.wok_ris, 320, "Рис, куриное филе, морковь, болгарский перец, стручковая фасоль, соус терияки, зеленый лук, кунжут.", ""))
        listDishes.add(DishDataModel(5, 2, "Норм Вок", R.drawable.wok_norm, 260, "Лапша удон пшеничная, сервелат, карбонад, соус на выбор, крымский лук, лук зеленый, специи.", ""))
        listDishes.add(DishDataModel(5, 3, "Хот боул с курицей", R.drawable.wok_chiken, 340, "Лапша удон/яичная, наггетсы, тайский соус, томаты, шампиньоны, лук зеленый, масло кунжутное, кунжут, лук фри.", ""))
        listDishes.add(DishDataModel(5, 4, "Хот боул Гавайский", R.drawable.wok_hawaii, 380, "Лапша удон/яичная, филе цыпленка, соус терияки, ананас, перец болгарский, лук зеленый, лук крымский, масло кунжутное, кунжут, лук фри.", ""))
        return listDishes
    }

    fun generate_just_eat(listDishes : ArrayList<DishDataModel>): ArrayList<DishDataModel> {
        listDishes.add(DishDataModel(6, 1, "Цезарь с цыпленком", R.drawable.just_eat_caesar, 310, "Салат айсберг, филе цыпленка, томаты, фирменный соус Цезарь, сухарики, яйцо, сыр пармезан.", ""))
        listDishes.add(DishDataModel(6, 2, "Солянка", R.drawable.just_eat_solyanka, 220, "Бульон куриный, сервелат, карбонад, филе цыпленка, лук крымский, маслины, огурцы маринованные, соус пикантный, специи, лимон", ""))
        listDishes.add(DishDataModel(6, 3, "Том Ям", R.drawable.just_eat_tom_yam, 370, "Куриный бульон, креветки тигровые, кокосовое молоко, паста том ям, паста тайская чили, шампиньоны, рыбный соус, томаты.", ""))
        listDishes.add(DishDataModel(6, 4, "Шоколадный чизкейк", R.drawable.just_eat_cheese_cake, 180, "Нежный сливочно-творожный десерт.", ""))
        return listDishes
    }

    fun generate_roll(listDishes : ArrayList<DishDataModel>): ArrayList<DishDataModel> {
        listDishes.add(DishDataModel(7, 1, "Немо", R.drawable.roll_nemo, 295, "Рис, водоросли нори, карбонад, форель терияки, творожный сыр Креметте, огурцы, стружка тунца.", ""))
        listDishes.add(DishDataModel(7, 2, "Филадельфия лайт", R.drawable.roll_filadelphy, 320, "Рис, форель, творожный сыр Креметте, огурец, водоросли нори.", ""))
        listDishes.add(DishDataModel(7, 3, "Топ сет", R.drawable.roll_top_set, 1035, "Филадельфия Лайт, Ханами, Атлантик Вулкан, Карибская диета. 4 видов, 32 штуки.", ""))
        listDishes.add(DishDataModel(7, 4, "Лучший сет", R.drawable.roll_best_set, 710, "Немо, Лазурный, На Барнео! 3 вида, 24 штуки.", ""))
        return listDishes
    }

    fun generate_drink(listDishes : ArrayList<DishDataModel>): ArrayList<DishDataModel> {
        listDishes.add(DishDataModel(8, 1, "Добрый кола (розлив)", R.drawable.drink_cola, 115, "Безалкогольный сильногазированный напиток, вкус “Кола”. На розлив. На выбор 300 или 500 мл.", ""))
        listDishes.add(DishDataModel(8, 2, "Сок палпи 0.45л Апельсин", R.drawable.drink_pulpy, 125, "Сокосодержащий напиток с цельной мякотью — «палпинками» и кусочками фруктов, который подарит взрывной вкус и наполнит яркими эмоциями. Со вкусом Апельсина! 450 мл", ""))
        listDishes.add(DishDataModel(8, 3, "Rich Tea 0.5л Лимон", R.drawable.drink_reach, 110, "Холодный черный чай со вкусом лимона. 500 мл.", ""))
        listDishes.add(DishDataModel(8, 4, "Американо", R.drawable.drink_americano, 60, "Крепкий кофе из натуральных зерен, необходимый чтобы взбодриться", ""))
        return listDishes
    }

    fun getDishes(category: Int) : ArrayList<DishDataModel>{
        var listDishes = ArrayList<DishDataModel>()
        when (category) {
            1 -> listDishes = generate_combo(listDishes)
            2 -> listDishes = generate_shava(listDishes)
            3 -> listDishes = generate_pizza(listDishes)
            4 -> listDishes = generate_free(listDishes)
            5 -> listDishes = generate_wok(listDishes)
            6 -> listDishes = generate_just_eat(listDishes)
            7 -> listDishes = generate_roll(listDishes)
            8 -> listDishes = generate_drink(listDishes)
        }
        return listDishes
    }
}