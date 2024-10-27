package com.example.lr2.activity.personinfo

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.lr2.R
import com.google.android.material.textfield.TextInputEditText

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

        //TODO раскоментить когда будет апи (получение инфы с бэка )
        //    ApiCall().getUserAddress(this, id) {
        //            addr ->
        //            street.setText(addr.street)
        //            home.setText(addr.home)
        //            flat.setText(addr.flat)
        //            comment.setText(addr.comment)
        //            homeName.setText(addr.homeName)


        saveButton = findViewById(R.id.saveButton)

        saveButton.setOnClickListener {
            //TODO УБРАТЬ после пояления апи
            Log.d("SAVE_DATA_STREET", street.text.toString())
            Log.d("SAVE_DATA_HOME", home.text.toString())
            Log.d("SAVE_DATA_FLAT", flot.text.toString())
            Log.d("SAVE_DATA_COMMENT", comment.text.toString())
            Log.d("SAVE_DATA_NAMEHOME", homeName.text.toString())
            //TODO после появления апи отправка данных с формы на бэк
            //val requestBody = AdressDataModel(
//                idUser = id,
//                street = street.text.toString(),
//                home = home.text.toString(),
//                flat = flat.text.toString(),
//                comment = comment.text.toString(),
//                homeName = homeName.text.toString())// Создайте тело запроса
//
//
//            CoroutineScope(Dispatchers.IO).launch {
//                ApiCall().saveAddress(requestBody, { response ->
//                    response?.let {
//                        if (it.isSuccess) {
//                          Log.d("SUCCSES_SAVE_DATA", "")
//                        } else {
//                            Log.d("SOMETHING_WRONG", "")
//                        }
//                    }
//                }, { throwable ->
//                    // Обработка ошибки сети
//                    runOnUiThread {
//                        Toast.makeText(
//                            this@FillPersonDataParamsActivity,
//                            "Network error: ${throwable.message}",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                })
        }


    }

}