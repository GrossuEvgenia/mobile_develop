package com.example.lr2.apicall

import android.content.Context
import android.widget.Toast
import com.example.lr2.apiservice.ApiService
import com.example.lr2.datamodel.AddressDataModel
import com.example.lr2.datamodel.DishCategoryDataModel
import com.example.lr2.datamodel.DishDataModel
import com.example.lr2.datamodel.PersonDataModel
import retrofit.Call
import retrofit.Callback
import retrofit.GsonConverterFactory
import retrofit.Response
import retrofit.Retrofit

/***
 * Класс для обработки post и get апросов от апи (ПОКА НЕ ИСПОЛЬЗУЕТСЯ)
 */
class ApiCall {
    var BASE_URL = "ТУТ БУДЕТ УРЛА ДО АПИ"

    /***
     * функция для обработки получения информации о пользователе
     */
    fun getUserData(context: Context, userId: Int, callback: (PersonDataModel) -> Unit) {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build()
        val service: ApiService = retrofit.create<ApiService>(ApiService::class.java)
        val call: Call<PersonDataModel> = service.getUserData(userId) {
            fun onResponse(response: Response<PersonDataModel>?, retrofit: Retrofit?) {
                if (response!!.isSuccess) {
                    val user: PersonDataModel = response.body() as PersonDataModel
                    callback(user)
                }
            }

            fun onFailure(t: Throwable?) {
                // This method is called when the API request fails.
                Toast.makeText(context, "Request Fail", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /***
     * функция для сохранения данных пользователя
     */
    fun saveUser(
        requestBody: PersonDataModel, onResult: (Response<PersonDataModel>?) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build()
        val service: ApiService = retrofit.create<ApiService>(ApiService::class.java)
        val call: Call<PersonDataModel> = service.saveUser(requestBody)
        call.enqueue(object : Callback<PersonDataModel> {
            override fun onResponse(response: Response<PersonDataModel>?, retrofit: Retrofit?) {
                onResult(response)
            }

            override fun onFailure(t: Throwable?) {
                if (t != null) {
                    onError(t)
                }
            }
        })
    }

    /***
     * Функция для получения информации о адресе пользователя
     */
    fun getUserAddres(context: Context, userId: Int, callback: (AddressDataModel) -> Unit) {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build()
        val service: ApiService = retrofit.create<ApiService>(ApiService::class.java)
        val call: Call<AddressDataModel> = service.getUserAddress(userId) {
            fun onResponse(response: Response<AddressDataModel>?, retrofit: Retrofit?) {
                if (response!!.isSuccess) {
                    val addr: AddressDataModel = response.body() as AddressDataModel
                    callback(addr)
                }
            }

            fun onFailure(t: Throwable?) {
                // This method is called when the API request fails.
                Toast.makeText(context, "Request Fail", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /***
     * Функия для сохранения данных о адресе пользователя
     */
    fun saveAddress(
        requestBody: AddressDataModel, onResult: (Response<AddressDataModel>?) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build()
        val service: ApiService = retrofit.create<ApiService>(ApiService::class.java)
        val call: Call<AddressDataModel> = service.saveAddress(requestBody)
        call.enqueue(object : Callback<AddressDataModel> {
            override fun onResponse(response: Response<AddressDataModel>?, retrofit: Retrofit?) {
                onResult(response)
            }

            override fun onFailure(t: Throwable?) {
                if (t != null) {
                    onError(t)
                }
            }
        })
    }

    /***
     * Функция для получения категорий блюд
     */
    fun getDishCategories(context: Context, callback: (ArrayList<DishCategoryDataModel>) -> Unit) {

        val retrofit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build()
        val service: ApiService = retrofit.create<ApiService>(ApiService::class.java)
        val call: Call<ArrayList<DishCategoryDataModel>> = service.getDishCategories {
            fun onResponse(response: Response<ArrayList<DishCategoryDataModel>>?, retrofit: Retrofit?) {
                if (response!!.isSuccess) {
                    val listDishCategory: ArrayList<DishCategoryDataModel> = response.body() as ArrayList<DishCategoryDataModel>
                    callback(listDishCategory)
                }
            }

            fun onFailure(t: Throwable?) {
                // This method is called when the API request fails.
                Toast.makeText(context, "Request Fail", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /***
     * Функция для получения блюда определенной категории
     */
    fun getDishes(context: Context, id_category: Int, callback: (ArrayList<DishDataModel>) -> Unit) {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build()
        val service: ApiService = retrofit.create<ApiService>(ApiService::class.java)
        val call: Call<ArrayList<DishDataModel>> = service.getDishes(id_category) {
            fun onResponse(response: Response<ArrayList<DishDataModel>>?, retrofit: Retrofit?) {
                if (response!!.isSuccess) {
                    val addr: ArrayList<DishDataModel> = response.body() as ArrayList<DishDataModel>
                    callback(addr)
                }
            }

            fun onFailure(t: Throwable?) {
                // This method is called when the API request fails.
                Toast.makeText(context, "Request Fail", Toast.LENGTH_SHORT).show()
            }
        }
    }
}