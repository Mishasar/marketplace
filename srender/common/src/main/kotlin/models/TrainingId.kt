package com.otus.otuskotlin.srender.commonMain.models

@JvmInline
value class TrainingId(private val id: UInt) {
    fun asString() = id

    companion object {
        val NONE = TrainingId(0U)
    }
}