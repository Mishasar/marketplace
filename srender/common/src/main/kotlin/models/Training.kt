package com.otus.otuskotlin.srender.commonMain.models

data class Training(
    val id: TrainingId = TrainingId.NONE,
    val groupSlug: String = "",
    val type: TrainingTypeId = TrainingTypeId.NONE,
    val name: String = "",
    val date: String = "",
    val userId: UserId = UserId.NONE
)