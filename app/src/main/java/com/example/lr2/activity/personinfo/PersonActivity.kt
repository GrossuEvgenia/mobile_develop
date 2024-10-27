package com.example.lr2.activity.personinfo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lr2.R

/***
 * Класс с активити для профиля клиенат (используется для задании иерархии переходов)
 */
class PersonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_person)
    }
}