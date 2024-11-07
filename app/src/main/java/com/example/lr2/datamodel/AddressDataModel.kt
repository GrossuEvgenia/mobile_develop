package com.example.lr2.datamodel

/***
 * Класс с данными для адреса пользователя
 */
data class AddressDataModel (
    var idUsed : Int,
    var street : String,
    var home : String,
    var flat : String,
    var homeName : String
) : java.io.Serializable