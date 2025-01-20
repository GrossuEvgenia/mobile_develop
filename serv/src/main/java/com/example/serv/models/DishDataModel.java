package com.example.serv.models;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class DishDataModel implements Serializable {

    public int idCategory;
    public int idDish;
    public String name;
    public int idImage;
    public int price;
    public int weight;
    public String description;
    public String compose;

}
