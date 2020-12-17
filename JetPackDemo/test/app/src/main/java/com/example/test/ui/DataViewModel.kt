package com.example.test.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel :ViewModel(){
    private val _name = MutableLiveData("wenxin")
    private val _password =MutableLiveData("123123")
    val name :LiveData<String> = _name
    val password :LiveData<String> = _password
}