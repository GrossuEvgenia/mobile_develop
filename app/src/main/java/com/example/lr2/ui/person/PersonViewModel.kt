package com.example.lr2.ui.person

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PersonViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Профиль"
    }
    val text: LiveData<String> = _text
}