package com.example.lr2.datamodel

/***
 * Класс с данными пользователя
 */
data class PersonDataModel(
    var id: Int,
    var name: String,
    var lastName: String,
    var phone: String,
    var email: String,
    var bday: String,
    var male: Int //1-fem, 0- man
) : java.io.Serializable