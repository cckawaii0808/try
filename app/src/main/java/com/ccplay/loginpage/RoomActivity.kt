package com.ccplay.loginpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.ccplay.loginpage.databinding.ActivityLoginBinding
import com.ccplay.loginpage.databinding.ActivityRoomBinding
import okhttp3.*
import okio.ByteString
import java.util.concurrent.TimeUnit

class RoomActivity : AppCompatActivity() {
    private var TAG = RoomActivity::class.java.simpleName
    lateinit var binding: ActivityRoomBinding
    lateinit var socket: WebSocket//創立websocket鑰匙
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "歡迎光臨聊天室")
        Toast.makeText(this, "歡迎光臨聊天室，請注意發言".toString(), Toast.LENGTH_LONG).show()//顯示bmi在小訊息匡
        val client = OkHttpClient.Builder().readTimeout(10, TimeUnit.SECONDS)//最多等延遲１０秒
            .build()
        val request = Request.Builder()
            .url("wss://lott-dev.lottcube.asia/ws/chat/chat:app_test?nickname=不會吧不會吧他居然會說話")
            .build()


        socket= client.newWebSocket(request, object : WebSocketListener() {
            //crtl+o可以複寫//要求寫一個傾聽器 他會自己去處理
            override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
                super.onClosed(webSocket, code, reason)
                Log.d(TAG,"onClosed")
            }

            override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
                super.onClosing(webSocket, code, reason)
                Log.d(TAG,"onClosing")
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                super.onFailure(webSocket, t, response)
                Log.d(TAG,"onFailure")

            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                super.onMessage(webSocket, text)
                Log.d(TAG,"onMessage:=$text")
            }

            override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
                super.onMessage(webSocket, bytes)
                Log.d(TAG,"onMessage=${bytes.hex()}")
            }

            override fun onOpen(webSocket: WebSocket, response: Response) {
                super.onOpen(webSocket, response)
                Log.d(TAG,"onOpen")
            }

        }
        )
        binding.bchatsend.setOnClickListener {
            val message=binding.chatbox.text.toString()
            val json = "{\"action\": \"N\", \"content\": \"$message\" }"
            socket.send(json)
        }
    }


}
