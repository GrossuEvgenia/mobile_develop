package com.example.serv.models;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class AddressDataModel implements Serializable {

    public int idUser;
    public String street;
    public String home;
    public String flat;
    public String comment;
    public String homeName;

}
