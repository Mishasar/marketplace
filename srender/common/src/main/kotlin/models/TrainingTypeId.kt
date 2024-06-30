package com.otus.otuskotlin.srender.commonMain.models

@JvmInline
value class TrainingTypeId(private val id: UInt) {
    fun asString() = id

    companion object {
        val NONE = TrainingTypeId(0U)
    }
}