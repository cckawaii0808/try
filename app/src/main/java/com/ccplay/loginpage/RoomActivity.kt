package com.ccplay.loginpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.ccplay.loginpage.databinding.ActivityLoginBinding
import com.ccplay.loginpage.databinding.ActivityRoomBinding

class RoomActivity : AppCompatActivity() {
    private var TAG = RoomActivity::class.java.simpleName
    lateinit var binding: ActivityRoomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "歡迎光臨聊天室")
        Toast.makeText(this, "歡迎光臨聊天室，請注意發言".toString(), Toast.LENGTH_LONG).show()//顯示bmi在小訊息匡
    }


}
