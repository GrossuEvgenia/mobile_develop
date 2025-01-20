package com.example.serv.models;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class AdditionModel implements Serializable {

    public int id;
    public String name;
    public int idImage;
    public int price;
    public int weight;

}
