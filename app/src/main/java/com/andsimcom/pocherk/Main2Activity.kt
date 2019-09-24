package com.andsimcom.pocherk

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback
import com.vk.api.sdk.exceptions.VKApiExecutionException

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val parameters = VKNewsParam.Builder()
            .filters("post")
            .build()
        Log.i("VKParameters", parameters.args.toString())
        val tv =findViewById<TextView>(R.id.textview)

        VK.execute(VKNewsRequest.NewsGet(parameters), object: VKApiCallback<VKNews> {
            override fun success(result: VKNews) {
                Log.i("VKWallGetResponse", result.toString())
                tv.text=result.toString()
            }

            override fun fail(error: VKApiExecutionException) {
                Log.e("VKApiExecutionException", error.errorMsg)
                tv.text=error.errorMsg
            }
        })
    }

}


