package com.example.lr2.activity.personinfo

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lr2.R
import com.example.lr2.apiclient.apis.UserApi
import com.example.lr2.apiclient.models.AddressDataModel
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/***
 * Класс для экрана с заполнением адреса
 */
class FillAdressActivity : AppCompatActivity() {
    lateinit var street: TextInputEditText
    lateinit var home: TextInputEditText
    lateinit var flot: TextInputEditText
    lateinit var comment: TextInputEditText
    lateinit var homeName: TextInputEditText
    lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_fill_address)
        StrictMode.setThreadPolicy(ThreadPolicy.Builder().permitAll().build())
        //id- пользователя, получается из главного эерана с профилем
        val id: Int = intent.getIntExtra("id", 0)

        //настройка top app bar экрана
        var actionBar = getSupportActionBar()
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back_vector);
            actionBar.setTitle("Добавление адреса")
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        //работа с полями на экране
        street = findViewById(R.id.street)
        home = findViewById(R.id.home)
        flot = findViewById(R.id.flat)
        comment = findViewById(R.id.comment)
        homeName = findViewById(R.id.nameHome)


        val userAddress = UserApi().getUserAddress(id)
        if(userAddress != null){
            street.setText(userAddress.street)
            home.setText(userAddress.home)
            flot.setText(userAddress.flat)
            comment.setText(userAddress.comment)
            homeName.setText(userAddress.homeName)
        }

        saveButton = findViewById(R.id.saveButton)

        saveButton.setOnClickListener {
            Log.d("SAVE_DATA_STREET", street.text.toString())
            Log.d("SAVE_DATA_HOME", home.text.toString())
            Log.d("SAVE_DATA_FLAT", flot.text.toString())
            Log.d("SAVE_DATA_COMMENT", comment.text.toString())
            Log.d("SAVE_DATA_NAMEHOME", homeName.text.toString())
            val requestBody = AddressDataModel(
                idUser = id,
                street = street.text.toString(),
                home = home.text.toString(),
                flat = flot.text.toString(),
                comment = comment.text.toString(),
                homeName = homeName.text.toString())


            CoroutineScope(Dispatchers.IO).launch {
                try {
                    UserApi().saveUserAddress(requestBody)
                    Log.d("SUCCSES_SAVE_DATA", "Сохранение успешно")
                } catch (e : RuntimeException){
                    Log.d("ERROR", "Ошибка сохранения")
                }
            }
        }
    }
}