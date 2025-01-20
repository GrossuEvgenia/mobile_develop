package com.example.lr2.activity.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.lr2.R
import com.example.lr2.ui.menu.MenuFragment

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.login_fragment_container, MenuFragment()) // Стартовый фрагмент
            }
        }
    }
}

