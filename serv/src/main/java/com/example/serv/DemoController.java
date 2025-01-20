package com.example.serv;

import com.example.serv.models.*;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class DemoController {

    Collection<DishDataModel> dishes = Arrays.asList(
            new DishDataModel(1, 1, "Комбо сытное DUO", 2131230855, 999, 120, "Для парочки любителей паназиатской кухни! Сытные сочные новинки хот-боулы, набор “Царский фри” с хрустящими закусками, а также напитком на выбор.", ""),
            new DishDataModel(1, 2, "Комбо КРАШик", 2131230851, 499, 120, "Нет шансов остаться равнодушным к комбо \"КРАШик\". Сочный свежий хот-дог с ароматными чигетсами и картофелем фри.", ""),
            new DishDataModel(1, 3, "Комбо для друзей", 2131230852, 1599, 120, "Собираетесь компанией из 4-6 человек?! Готовое решение для вас. Включает в себя вкусные хиты и новинку пицца итальянская Бургер.", ""),
            new DishDataModel(1, 4, "Комбо на завтрак", 2131230854, 999, 120, "Нет проблем, если не успел позавтракать. Используй готовое решение.", ""),
            new DishDataModel(2, 5, "Грибная", 2131231015, 300, 120, "Лаваш, филе цыпленка, соус на выбор, шампиньоны, картофель фри, крымский лук.", ""),
            new DishDataModel(2, 6, "Цезарь", 2131231011, 300, 120, "Лаваш, филе цыпленка, соус на выбор, огурец, томаты, сыр моцарелла, капуста, картофель фри.", ""),
            new DishDataModel(2, 7, "Сырная", 2131231012, 280, 120, "Лаваш, филе цыпленка, томаты, сыр моцарелла, сыр чеддер, капуста, соус сырный.", ""),
            new DishDataModel(2, 8, "Грильяс домашний", 2131231013, 280, 120, "Пшеничная лепешка, филе цыпленка, капуста, картофель фри, лук фри, бекон, болгарский перец, соус “Сладкий черри”.", ""),
            new DishDataModel(3, 9, "Бургер", 2131231001, 680, 120, "Тесто, соус красный, сыр моцарелла, бекон, рубленное филе цыпленка в томатном соусе, огурцы маринованные, томаты, лук фри, соус гриль, орегано. Диаметр - 30 см.", ""),
            new DishDataModel(3, 10, "Жульен", 2131231004, 620, 120, "Тесто, филе цыпленка, соус цезарь, шампиньоны жареные, лук крымский, лук фри, соус горчичный, орегано. Диаметр - 30 см.", ""),
            new DishDataModel(3, 11, "Морская", 2131231005, 820, 120, "Тесто, соус цезарь, соус том ям, сыр моцарелла, шампиньоны, креветки, томаты, орегано. Диаметр - 30 см.", ""),
            new DishDataModel(3, 12, "Сырная", 2131231002, 590, 120, "Тесто, соус цезарь, сыр моцарелла, соус сырный, сыр пармезан, сыр чеддер, орегано. Диаметр - 30 см", ""),
            new DishDataModel(4, 13, "Картофель фри 100гр", 2131230888, 110, 120, "Обжаренная до хрустящей корочки аппетитная картошка", ""),
            new DishDataModel(4, 14, "Крылья барбекю", 2131230885, 390, 120, "Порция из 5 или 9 сегментов крыла цыпленка в соусе барбекю.", ""),
            new DishDataModel(4, 15, "Хот-дог Жгучий", 2131230886, 280, 120, "Булочка, сосиска, салат айсберг, соус цезарь, огурцы маринованные, соус пикантный, соус горчичный, лук фри, перец халапеньо", ""),
            new DishDataModel(4, 16, "Хот-дог Классический", 2131230887, 280, 120, "Булочка, сосиска, салат айсберг, соус цезарь, огурцы маринованные, соус пикантный, соус горчичный, лук фри.", ""),
            new DishDataModel(5, 17, "Терияки Рис", 2131231024, 320, 120, "Рис, куриное филе, морковь, болгарский перец, стручковая фасоль, соус терияки, зеленый лук, кунжут.", ""),
            new DishDataModel(5, 18, "Норм Вок", 2131231023, 260, 120, "Лапша удон пшеничная, сервелат, карбонад, соус на выбор, крымский лук, лук зеленый, специи.", ""),
            new DishDataModel(5, 19, "Хот боул с курицей", 2131231020, 340, 120, "Лапша удон/яичная, наггетсы, тайский соус, томаты, шампиньоны, лук зеленый, масло кунжутное, кунжут, лук фри.", ""),
            new DishDataModel(5, 20, "Хот боул Гавайский", 2131231021, 380, 120, "Лапша удон/яичная, филе цыпленка, соус терияки, ананас, перец болгарский, лук зеленый, лук крымский, масло кунжутное, кунжут, лук фри.", ""),
            new DishDataModel(6, 21, "Цезарь с цыпленком", 2131230922, 310, 120, "Салат айсберг, филе цыпленка, томаты, фирменный соус Цезарь, сухарики, яйцо, сыр пармезан.", ""),
            new DishDataModel(6, 22, "Солянка", 2131230925, 220, 120, "Бульон куриный, сервелат, карбонад, филе цыпленка, лук крымский, маслины, огурцы маринованные, соус пикантный, специи, лимон", ""),
            new DishDataModel(6, 23, "Том Ям", 2131230926, 370, 120, "Куриный бульон, креветки тигровые, кокосовое молоко, паста том ям, паста тайская чили, шампиньоны, рыбный соус, томаты.", ""),
            new DishDataModel(6, 24, "Шоколадный чизкейк", 2131230923, 180, 120, "Нежный сливочно-творожный десерт.", ""),
            new DishDataModel(7, 25, "Немо", 2131231008, 295, 120, "Рис, водоросли нори, карбонад, форель терияки, творожный сыр Креметте, огурцы, стружка тунца.", ""),
            new DishDataModel(7, 26, "Филадельфия лайт", 2131231007, 320, 120, "Рис, форель, творожный сыр Креметте, огурец, водоросли нори.", ""),
            new DishDataModel(7, 27, "Топ сет", 2131231009, 1035, 120, "Филадельфия Лайт, Ханами, Атлантик Вулкан, Карибская диета. 4 видов, 32 штуки.", ""),
            new DishDataModel(7, 28, "Лучший сет", 2131231006, 710, 120, "Немо, Лазурный, На Барнео! 3 вида, 24 штуки.", ""),
            new DishDataModel(8, 29, "Добрый кола (розлив)", 2131230881, 115, 120, "Безалкогольный сильногазированный напиток, вкус “Кола”. На розлив. На выбор 300 или 500 мл.", ""),
            new DishDataModel(8, 30, "Сок палпи 0.45л Апельсин", 2131230883, 125, 120, "Сокосодержащий напиток с цельной мякотью — «палпинками» и кусочками фруктов, который подарит взрывной вкус и наполнит яркими эмоциями. Со вкусом Апельсина! 450 мл", ""),
            new DishDataModel(8, 31, "Rich Tea 0.5л Лимон", 2131230884, 110, 120, "Холодный черный чай со вкусом лимона. 500 мл.", ""),
            new DishDataModel(8, 32, "Американо", 2131230880, 60, 120, "Крепкий кофе из натуральных зерен, необходимый чтобы взбодриться", "")
    );
    Collection<PersonDataModel> users = new ArrayList<>();
    Collection<AddressDataModel> addresses = new ArrayList<>();

    @GetMapping("/dish/categories")
    public ResponseEntity<Collection<DishCategoryDataModel>> getDishCategories() {
        Collection<DishCategoryDataModel> result = new ArrayList<>();
        result.add(new DishCategoryDataModel(1, "Комбо", 2131230853));
        result.add(new DishCategoryDataModel(2, "Шаурма", 2131231014));
        result.add(new DishCategoryDataModel(3, "Пицца", 2131231003));
        result.add(new DishCategoryDataModel(4, "Фри", 2131230889));
        result.add(new DishCategoryDataModel(5, "Вок", 2131231022));
        result.add(new DishCategoryDataModel(6, "Просто поесть", 2131230924));
        result.add(new DishCategoryDataModel(7, "Роллы", 2131231010));
        result.add(new DishCategoryDataModel(8, "Напитки", 2131230882));
        return ResponseEntity.of(Optional.of(result));
    }

    @GetMapping("/dish")
    public ResponseEntity<DishDataModel> getDish(@RequestParam("idDish") int id) {
        DishDataModel result = dishes.stream().filter(v -> v.idDish == id).findAny().orElse(null);
        return ResponseEntity.of(Optional.ofNullable(result));
    }

    @GetMapping("/dish/additions")
    public ResponseEntity<Collection<AdditionModel>> getDishAddition(@RequestParam("idDish") int id) {
        Collection<AdditionModel> result = new ArrayList<>();
        return ResponseEntity.of(Optional.of(result));
    }

    @GetMapping("/dishes")
    public ResponseEntity<Collection<DishDataModel>> getDishes(@RequestParam("idCategory") int id) {
        Collection<DishDataModel> result = dishes.stream().filter(v -> v.idCategory == id).collect(Collectors.toList());
        return ResponseEntity.of(Optional.of(result));
    }

    @GetMapping("/restaurants")
    public ResponseEntity<Collection<RestaurantModel>> getRestaurants() {
        Collection<RestaurantModel> result = new ArrayList<>();
        result.add(new RestaurantModel(1, 53.34395, 83.78078, "ул Ленина, 47"));
        result.add(new RestaurantModel(2, 53.34633, 83.78773, "пр-т Комсомольский, 102"));
        result.add(new RestaurantModel(3, 53.342558, 83.768451, "ул Крупской, 91"));
        result.add(new RestaurantModel(4, 53.337603, 83.773561, "пр-т Красноармейский, 61"));
        result.add(new RestaurantModel(5, 53.34975, 83.76375, "пр-т Социалистический, 130"));
        return ResponseEntity.of(Optional.of(result));
    }

    @GetMapping("/user/address")
    public ResponseEntity<AddressDataModel> getUserAddress(@RequestParam("id") int id) {
        AddressDataModel result = addresses.stream().filter(v -> v.idUser == id).findAny().orElse(new AddressDataModel(0, "", "", "", "", ""));
        return ResponseEntity.of(Optional.of(result));
    }

    @GetMapping("/user")
    public ResponseEntity<PersonDataModel> getUserData(@RequestParam("id") int id) {
        PersonDataModel result = users.stream().filter(v -> v.id == id).findAny().orElse(new PersonDataModel(0, "", "", "", "", "", 0));
        return ResponseEntity.of(Optional.of(result));
    }

    @PostMapping("/user/address")
    public ResponseEntity<AddressDataModel> saveUserAddress(@RequestBody AddressDataModel body) {
        addresses.removeIf(v -> v.idUser == body.idUser);
        if(body.street != null && !body.street.isEmpty()){
            addresses.add(body);
        }
        return ResponseEntity.of(Optional.of(body));
    }

    @PostMapping("/user")
    public ResponseEntity<PersonDataModel> saveUserData(@RequestBody PersonDataModel body) {
        users.removeIf(v -> v.id == body.id);
        if(body.name != null && !body.name.isEmpty()){
            users.add(body);
        }
        return ResponseEntity.of(Optional.of(body));
    }

}
