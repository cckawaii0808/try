package com.ccplay.loginpage

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import com.ccplay.loginpage.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val TAG = LoginActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.blogin.setOnClickListener {
            var intent = Intent(this, RoomActivity::class.java)
            val username = binding.etuser.text.toString()
            val password = binding.etpass.text.toString()
            if (username == "cc" && password == "1234") {
                Log.d(TAG, "密碼正確")
                startActivity(intent)
            } else {
                Log.d(TAG, "密碼錯誤")
                 AlertDialog.Builder(this)
                    .setTitle("登入失敗")
                    .setMessage("請重新嘗試")
                    .setPositiveButton("ok", null)
                    .show()
            }

        }
    }
}
