package com.ccplay.loginpage

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import com.ccplay.loginpage.databinding.ActivityLoginBinding
import com.ccplay.loginpage.databinding.ActivityRoomBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val TAG = LoginActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.blogin.setOnClickListener {
            var intent = Intent(this, RoomActivity::class.java)
            var remember = false//宣告變數勾選的預設為否

        }
        val pref =getSharedPreferences("member_data", Context.MODE_PRIVATE)
        val prefUser = pref.getString("USER", "")
        if (prefUser != "") {
            binding.etuser.setText(prefUser)
        }
        binding.blogin.setOnClickListener {
            val username = binding.etuser.text.toString()
            val password = binding.etpass.text.toString()
            if (username == "cc" && password == "1234") {
                Log.d(TAG, "密碼正確")
                pref.edit().putString("USER", username).putInt("LEVEL", 3)
                    .apply()
                var intent = Intent(this, RoomActivity::class.java)
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
