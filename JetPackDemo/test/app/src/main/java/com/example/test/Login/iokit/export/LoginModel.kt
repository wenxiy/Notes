package com.example.test.Login.iokit.export

import com.example.test.data.AccountBean

class LoginModel() {
    fun login(): AccountBean {
        return AccountBean("wenxin", "193", "123456")
    }
}