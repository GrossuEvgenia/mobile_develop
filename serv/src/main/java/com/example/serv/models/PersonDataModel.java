package com.example.serv.models;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class PersonDataModel implements Serializable {

    public int id;
    public String name;
    public String lastName;
    public String phone;
    public String email;
    public String bday;
    public int male;

}
