package com.otus.otuskotlin.srender.commonMain.core

enum class Environment(val value: String) {
    PROD("prod"),

    TEST("test"),

    STUB("stub"),

    ;

    companion object {
        fun fromString(value: String) = values().firstOrNull { it.value == value }
    }
}
