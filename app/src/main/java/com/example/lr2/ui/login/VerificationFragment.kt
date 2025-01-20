package com.example.lr2.ui.login

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lr2.R


class VerificationFragment : Fragment(R.layout.fragment_verification) {

    private val correctCode = "123456" // Фиксированный код для учебного проекта

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val codeEditText = view.findViewById<EditText>(R.id.codeEditText)
        val verifyButton = view.findViewById<Button>(R.id.verifyButton)

        verifyButton.setOnClickListener {
            val verificationCode = codeEditText.text.toString().trim()

            if (verificationCode == correctCode) {
                // Логика успешной верификации: сохраняем данные и переходим в профиль
                onLoginSuccess()
            } else {
                Toast.makeText(requireContext(), "Неверный код", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun onLoginSuccess() {
        // Сохраняем состояние авторизации в SharedPreferences
        val sharedPreferences = requireActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("isLoggedIn", false)
        editor.apply()

        // Переход на страницу профиля или меню
        findNavController().navigate(R.id.action_verificationFragment_to_profileFragment)
    }
}
