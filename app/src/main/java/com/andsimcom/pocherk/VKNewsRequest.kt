package com.andsimcom.pocherk

import com.google.gson.GsonBuilder
import com.vk.api.sdk.VKApiManager
import com.vk.api.sdk.VKApiResponseParser
import com.vk.api.sdk.VKMethodCall
import com.vk.api.sdk.exceptions.VKApiIllegalResponseException
import com.vk.api.sdk.internal.ApiCommand
import org.json.JSONException
import org.json.JSONObject

class VKNewsRequest {
    class NewsGet(private val parameters: VKNewsParam):ApiCommand<VKNews>(){
        override fun onExecute(manager: VKApiManager): VKNews {
            val call=VKMethodCall.Builder()
                .method("newsfeed.get")
                .args(parameters.args)
                .version(manager.config.version)
                .build()
            return manager.execute(call, ResponseApiParser())
        }
    class ResponseApiParser:VKApiResponseParser<VKNews>{
        override fun parse(response: String): VKNews {
            try{
                val joResponse = JSONObject(response).getJSONObject("response")
                val gson = GsonBuilder().setPrettyPrinting().create()
                return gson.fromJson(joResponse.toString(), VKNews::class.java)
            } catch (ex: JSONException) {
                throw VKApiIllegalResponseException(ex)
            }
        }
    }


    }
}