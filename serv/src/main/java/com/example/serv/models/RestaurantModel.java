package com.example.serv.models;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class RestaurantModel implements Serializable {

    public int idPoint;
    public double x;
    public double y;
    public String address;

}
