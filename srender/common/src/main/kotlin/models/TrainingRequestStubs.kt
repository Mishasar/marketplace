package com.otus.otuskotlin.srender.commonMain.models

enum class TrainingRequestStubs(val value: String) {
    SUCCESS("success"),

    NOT_FOUND("notFound"),

    BAD_ID("badId"),

    BAD_TEXT("badText"),

    BAD_ANSWER("badAnswer"),

    CANNOT_DELETE("cannotDelete"),

    BAD_SEARCH_STRING("badSearchString");

    companion object {
        fun fromString(value: String): TrainingRequestStubs = values().first { it.value == value }
    }
}

