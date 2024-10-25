package com.example.lr2.ui.fillpersdata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FillPersonDataViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "SUKA NAHUI BLUT"
    }
    val text: LiveData<String> = _text
}