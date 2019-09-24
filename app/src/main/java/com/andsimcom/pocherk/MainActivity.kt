package com.andsimcom.pocherk

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKTokenExpiredHandler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val tokenTracker = object: VKTokenExpiredHandler {
        override fun onTokenExpired() {
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        VK.addTokenExpiredHandler(tokenTracker)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this,snchoose::class.java)
            startActivity(intent)  }
    }
}
