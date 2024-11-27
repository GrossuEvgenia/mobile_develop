package com.example.lr2.apiservice

import com.example.lr2.datamodel.AddressDataModel
import com.example.lr2.datamodel.DishCategoryDataModel
import com.example.lr2.datamodel.DishDataModel
import com.example.lr2.datamodel.PersonDataModel
import retrofit.Call
import retrofit.http.Body
import retrofit.http.Field
import retrofit.http.GET
import retrofit.http.POST
import retrofit.http.Query
import java.util.Date

/***
 * Интерфейс, который определяет апи для бэка (ВОЗМОЖНО НУЖНО БУДЕТ РЕДАКТИРОВАТЬ)
 */
interface ApiService {

    @GET("/user/{id}")
    fun getUserData(@Query("id") id: Int, function: () -> Unit): Call<PersonDataModel>

    @POST("/saveuser")
    fun saveUser(@Body requestBody: PersonDataModel): Call<PersonDataModel>

    @GET("/userAddress/{id}")
    fun getUserAddress(@Query("id") id: Int, function: () -> Unit): Call<AddressDataModel>

    @POST("/saveuserAddress")
    fun saveAddress(@Body requestBody: AddressDataModel):  Call<AddressDataModel>

    @GET("/dish/categories")
    fun getDishCategories(function: () -> Unit):  Call<ArrayList<DishCategoryDataModel>>

    @GET("/dishes")
    fun getDishes(@Query("id_category") id_category: Int, function: () -> Unit):  Call<ArrayList<DishDataModel>>

}