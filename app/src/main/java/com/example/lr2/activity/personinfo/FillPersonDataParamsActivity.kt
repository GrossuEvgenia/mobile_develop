package com.example.lr2.activity.personinfo

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.example.lr2.R
import com.example.lr2.apiclient.apis.UserApi
import com.example.lr2.apiclient.models.PersonDataModel
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/***
 * Класс с активностью для экрана с редактированием данных пользователя
 */
class FillPersonDataParamsActivity : AppCompatActivity() {
    lateinit var name: TextInputEditText
    lateinit var lastName: TextInputEditText
    lateinit var phone: TextInputEditText
    lateinit var email: TextInputEditText
    lateinit var birhDate: TextInputEditText
    lateinit var man: RadioButton
    lateinit var female: RadioButton
    lateinit var deleteButton: Button
    lateinit var saveButton: Button
    var maleVar: Int =0


    @SuppressLint("RestrictedApi", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id: Int = intent.getIntExtra("id", 0)
        Log.d("AddressActivity", id.toString())
        setContentView(R.layout.fragment_fillpersdata)
        StrictMode.setThreadPolicy(ThreadPolicy.Builder().permitAll().build())
        //настройка top app bar экрана
        var actionBar = getSupportActionBar()
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back_vector);
            actionBar.setTitle("Мои данные")
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        //работа с компонентами формы
        name = findViewById(R.id.userName)
        lastName = findViewById(R.id.lastName)
        phone = findViewById(R.id.phone)
        email = findViewById(R.id.email)
        birhDate = findViewById(R.id.birthData)
        man = findViewById(R.id.radioM)
        female = findViewById(R.id.radioF)

        name.setText("ЛЮСЯ")
        lastName.setText("ЛЮСЬЕВНА")
        phone.setText("+6-666-666-66-66")
        email.setText("luciq@hi.ru")

        val user = UserApi().getUserData(id)
        if(user != null){
            name.setText(user.name)
            lastName.setText(user.lastName)
            phone.setText(user.phone)
            email.setText(user.email)
            birhDate.setText(user.bday.toString())
            if (user.male == 0) {
                female.setChecked(true)
                man.setChecked(false)
            } else {
                man.setChecked(true)
                female.setChecked(false)
            }
        } else {
            man.setChecked(true)
            female.setChecked(false)
        }


        if(female.isChecked){
            maleVar = 1
        }
        saveButton = findViewById(R.id.saveButton)
        saveButton.setOnClickListener {
            Log.d("SAVE_DATA_NAME", name.text.toString())
            Log.d("SAVE_DATA_LAST_NAME", lastName.text.toString())
            Log.d("SAVE_DATA_PHONE", phone.text.toString())
            Log.d("SAVE_DATA_EMAIL", email.text.toString())
            Log.d("SAVE_DATA_DBDAY", birhDate.text.toString())


            val requestBody = PersonDataModel(
                id = id,
                name = name.text.toString(),
                lastName = lastName.text.toString(),
                phone = phone.text.toString(),
                email = email.text.toString(),
                bday = birhDate.text.toString(),
                male = maleVar
            )


            CoroutineScope(Dispatchers.IO).launch {
                try {
                    UserApi().saveUserData(requestBody)
                    Log.d("SUCCSES_SAVE_DATA", "Сохранение успешно")
                } catch (e: RuntimeException) {
                    Log.d("ERROR", "Ошибка сохранения")
                }
            }
        }
        deleteButton = findViewById(R.id.resetButton)

        deleteButton.setOnClickListener {
            val builder = AlertDialog.Builder(this@FillPersonDataParamsActivity)
            builder.setMessage("Уверены, что хотите удалить данные?")
                .setCancelable(false)
                .setPositiveButton("Да") { dialog, idd ->
                    name.setText("")
                    lastName.setText("")
                    phone.setText("")
                    email.setText("")
                    birhDate.setText("")
                    val requestBody = PersonDataModel(
                        id = id,
                        name = "",
                        lastName = "",
                        phone = "",
                        email = "",
                        bday = "",
                        male = 0
                    )// Создайте тело запроса

                    CoroutineScope(Dispatchers.IO).launch {
                        try {
                            UserApi().saveUserData(requestBody)
                            Log.d("SUCCSES_SAVE_DATA", "Сохранение успешно")
                        } catch (e: RuntimeException) {
                            Log.d("ERROR", "Ошибка сохранения")
                        }
                    }
                }.setNegativeButton("Нет") { dialog, id ->
                    // Dismiss the dialog
                    dialog.dismiss()
                }
            val alert = builder.create()
            alert.show()
        }

        //навешивание кликера для выбора даты на текстлайоут
        birhDate.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                R.style.CustomDatePickerDialog,
                { view, year, monthOfYear, dayOfMonth ->
                    val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    birhDate.setText(dat)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }
    }
}






