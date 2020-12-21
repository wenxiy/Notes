package com.example.test.Login.iokit.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test.data.AccountBean
import com.example.test.Login.iokit.export.LoginModel

class DataViewModel : ViewModel() {
    private var loginModel = LoginModel()
    private var accountBean = MutableLiveData<List<AccountBean>>()
    fun getAccountBean() {
//        viewModelScope.launch {
//            try {
//                val accountdata = withContext(Dispatchers.IO) {
//
//                }
//            }
        }
    }