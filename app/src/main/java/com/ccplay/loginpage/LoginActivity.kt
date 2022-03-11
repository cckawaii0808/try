package com.ccplay.loginpage

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
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
        loginandremember()
    }

    private fun loginandremember() {
        var remember = false//宣告一個為否的變數存不打勾
        val pref = getSharedPreferences("USERDATA", MODE_PRIVATE)//設定資料夾名字
        val prefUser = pref.getString("USER", "")//設定預設本地存帳號字串
        val checked = pref.getBoolean("rem_yes", false)//設定本地存預設勾選是否
        binding.ckremember.isChecked = checked//記憶我的勾選值為取得的布林值
        binding.ckremember.setOnCheckedChangeListener { compoundButton, checked ->//設定監聽如果勾選
            remember = checked//現在的勾選狀態同步到本地
            pref.edit().putBoolean("rem_yes", remember).apply()//本地存狀態
            if (!checked) {
                pref.edit().putString("USER", "").apply()
            }
        }
        if (prefUser != "") {//如果本地有值，請幫我輸入使用者帳號
            binding.etuser.setText(prefUser)
        }
        binding.blogin.setOnClickListener {//當我按下登入
            val username = binding.etuser.text.toString()
            val password = binding.etpass.text.toString()
            if (username == "cc" && password == "1234") {

                if (remember) {//如果勾選記憶我，放我的名字到本地的使用者帳號
                    pref.edit().putString("USER", username).putInt("LEVEL", 3).apply()//
                    Log.d(TAG, "密碼正確")
                }
                val intent = Intent(this, RoomActivity::class.java)//設定跳轉位置
                startActivity(intent)//執行跳轉
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
