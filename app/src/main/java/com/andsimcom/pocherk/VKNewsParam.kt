package com.andsimcom.pocherk


class VKNewsParam(b: Builder) {
    class Builder{
        var args: MutableMap<String,String> = LinkedHashMap()
        fun filters(filters: String) = apply { this.args["filters"] = filters}
        fun build() = VKNewsParam(this)
    }
    val args: Map<String,String>

    init {
        this.args = b.args
    }
}