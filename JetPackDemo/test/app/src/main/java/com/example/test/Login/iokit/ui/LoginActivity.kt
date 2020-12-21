package com.example.test.Login.iokit.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.test.Mainpage.MainPageActivity
import com.example.test.R
import com.example.test.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProviders.of(this).get(DataViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_login
        )
        binding.lifecycleOwner = this  // use Fragment.viewLifecycleOwner for fragments
        // binding.viewmodel = viewModel
        register_go.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "click", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainPageActivity::class.java)
            startActivity(intent)
        })

    }
}