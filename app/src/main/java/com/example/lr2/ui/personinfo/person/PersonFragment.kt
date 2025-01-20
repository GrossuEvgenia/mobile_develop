package com.example.lr2.ui.personinfo.person

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lr2.R
import com.example.lr2.databinding.FragmentPersonBinding

class PersonFragment : Fragment() {

    private var _binding: FragmentPersonBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Проверка авторизации
        if (!isUserLoggedIn()) {
            findNavController().navigate(R.id.loginFragment)
            return null // Прерываем создание фрагмента
        }

        // Привязка разметки с помощью ViewBinding
        _binding = FragmentPersonBinding.inflate(inflater, container, false)

    // Обработчик кнопки "Выйти"
        binding.out.setOnClickListener {
            logoutUser() // Вызов метода выхода
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * Проверяет, авторизован ли пользователь
     * @return true, если авторизован, иначе false
     */
    private fun isUserLoggedIn(): Boolean {
        val sharedPreferences = requireActivity().getSharedPreferences("UserPrefs", 0)
        return sharedPreferences.getBoolean("isLoggedIn", false)
    }

    private fun logoutUser() {
        val sharedPreferences = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        sharedPreferences.edit().putBoolean("isLoggedIn", false).apply()
        findNavController().navigate(R.id.loginFragment)
    }
}
