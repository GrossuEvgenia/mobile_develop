package com.example.serv.models;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class DishCategoryDataModel implements Serializable {

    public Integer idDishCategory;
    public String name;
    public Integer image_id;

}
