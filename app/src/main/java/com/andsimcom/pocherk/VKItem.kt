package com.andsimcom.pocherk

import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject

data class VKItem(
    val type:String,
    val sid:Int ,
    val time:Int ,
    val pid:Int ,
    val ptype:String
)/**:Parcelable{
    constructor(parcel:Parcel):this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()
        )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeInt(sid)
        parcel.writeInt(time)
        parcel.writeInt(pid)
        parcel.writeString(ptype)

    }
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<VKItem>{
        override fun createFromParcel(parcel: Parcel): VKItem {
            return VKItem(parcel)
        }

        override fun newArray(size: Int): Array<VKItem?> {
            return arrayOfNulls(size)
        }
        fun parce(json:JSONObject)
        =VKItem(
            type = json.optString("type", ""),
            sid = json.optInt("source_id", 0),
            time = json.optInt("time", 0),
            pid = json.optInt("post_id",0),
            ptype = json.optString("post_type","")
        )

    }


}
**/