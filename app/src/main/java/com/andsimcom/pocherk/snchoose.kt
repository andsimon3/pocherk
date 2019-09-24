package com.andsimcom.pocherk

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.auth.VKScope

class snchoose : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snchoose)
        val buttonvk = findViewById<Button>(R.id.buttonvk)
        buttonvk.setOnClickListener { VK.login(this, arrayListOf(VKScope.ADS,VKScope.AUDIO,VKScope.DOCS,VKScope.EMAIL,VKScope.FRIENDS,VKScope.GROUPS,VKScope.MARKET,VKScope.NOTES,VKScope.NOTIFICATIONS,VKScope.NOTIFY,VKScope.OFFLINE,VKScope.PAGES,VKScope.PHONE,VKScope.STATS,VKScope.STATUS,VKScope.STORIES,VKScope.VIDEO,VKScope.WALL))
            }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val callback = object: VKAuthCallback {
            override fun onLogin(token: VKAccessToken) {
                val intent = Intent(this@snchoose,Main2Activity::class.java)
                startActivity(intent)
            }

            override fun onLoginFailed(errorCode: Int) {
                val intent = Intent(this@snchoose,snchoose::class.java)
                startActivity(intent)
            }
        }
        if (data == null || !VK.onActivityResult(requestCode, resultCode, data, callback)) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
