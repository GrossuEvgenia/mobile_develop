package com.example.lr2.ui.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenuViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Здесь будет меню"
    }
    val text: LiveData<String> = _text
}