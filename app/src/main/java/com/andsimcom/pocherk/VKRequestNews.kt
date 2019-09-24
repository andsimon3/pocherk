package com.andsimcom.pocherk
/**
import com.vk.api.sdk.requests.VKRequest
import org.json.JSONObject

class VKRequestNews: VKRequest<List<VKNews>> {
    constructor(uids: IntArray = intArrayOf()): super("users.get") {
        if (uids.isNotEmpty()) {
            addParam("user_ids", uids.joinToString(","))
        }
        addParam("fields", "photo_200")
    }

    override fun parse(r: JSONObject): List<VKNews> {
        val users = r.getJSONArray("response")
        val result = ArrayList<VKNews>()
        for (i in 0 until users.length()) {
            result.add(VKNews.parse(users.getJSONObject(i)))
        }
        return result
    }
}**/