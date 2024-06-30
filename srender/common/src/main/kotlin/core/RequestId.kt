package com.otus.otuskotlin.srender.commonMain.core

@JvmInline
value class RequestId(private val id: String) {
    fun asString() = id

    companion object {
        val NONE = RequestId("")
    }
}