package com.ccplay.loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.ccplay.loginpage.databinding.ActivityMainBinding
import kotlin.contracts.contract

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        buttomaction()//按鈕監聽設定


    }

    private fun buttomaction() {
        binding.bperson.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.broom.setOnClickListener {
            var intent = Intent(this,RoomActivity::class.java)
            startActivity(intent)
        }
        binding.bsearch.setOnClickListener {
            var intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
    }


}
