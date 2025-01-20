package com.example.lr2.activity.ui.verification

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.lr2.R
import com.example.lr2.ui.login.VerificationFragment

class VerificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

        val phoneNumber = intent.getStringExtra("phoneNumber") // Получаем номер телефона из Intent

        // Загружаем VerificationFragment в контейнер
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.verification_fragment_container, VerificationFragment().apply {
                    arguments = Bundle().apply {
                        putString("phoneNumber", phoneNumber) // Передаем номер телефона в фрагмент
                    }
                })
            }
        }
    }
}
