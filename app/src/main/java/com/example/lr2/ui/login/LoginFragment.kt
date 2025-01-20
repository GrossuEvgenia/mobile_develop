package com.example.lr2.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lr2.R

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val phoneEditText = view.findViewById<EditText>(R.id.phoneEditText)
        val loginButton = view.findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val phoneNumber = phoneEditText.text.toString().trim()

            if (phoneNumber.isNotEmpty() && phoneNumber.length >= 10) {
                // Сохраняем статус авторизации
                val sharedPreferences = requireActivity().getSharedPreferences("UserPrefs", 0)
                val editor = sharedPreferences.edit()
                editor.putBoolean("isLoggedIn", true)
                editor.apply()

                // Переход в профиль
                findNavController().navigate(R.id.action_verificationFragment_to_profileFragment)
            } else {
                Toast.makeText(
                    requireContext(),
                    "Введите корректный номер телефона",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }
}
