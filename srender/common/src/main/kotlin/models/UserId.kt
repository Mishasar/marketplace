package com.otus.otuskotlin.srender.commonMain.models

@JvmInline
value class UserId(private val id: UInt) {
    fun asString() = id

    companion object {
        val NONE = UserId(0U)
    }
}