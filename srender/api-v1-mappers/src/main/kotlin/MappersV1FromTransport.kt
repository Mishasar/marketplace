package com.otus.otuskotlin.srender

import com.otus.otuskotlin.srender.commonMain.*
import com.otus.otuskotlin.srender.api.v1.models.*
import com.otus.otuskotlin.srender.commonMain.core.Command
import com.otus.otuskotlin.srender.commonMain.core.Environment
import com.otus.otuskotlin.srender.commonMain.models.*
import java.lang.Exception

fun TrainingContext.fromTransport(request: IRequest) = when (request) {
    is TrainingCreateRequest -> fromTransport(request)
    is TrainingReadRequest -> fromTransport(request)
    is TrainingUpdateRequest -> fromTransport(request)
    is TrainingDeleteRequest -> fromTransport(request)
    is TrainingSearchRequest -> fromTransport(request)
    else -> throw Exception(request.javaClass.toString())
}

fun TrainingContext.fromTransport(request: TrainingCreateRequest) {
    command = Command.CREATE
    trainingRequest = request.training?.toInternal() ?: Training()
    environment = request.debug?.mode?.toEnv() ?: Environment.PROD
    trainingRequestStubs = request.debug?.stub?.toInternal()
}

fun TrainingContext.fromTransport(request: TrainingReadRequest) {
    command = Command.READ
    trainingRequest = request.training?.toInternal() ?: Training()
    environment = request.debug?.mode?.toEnv() ?: Environment.PROD
    trainingRequestStubs = request.debug?.stub?.toInternal()
}

fun TrainingContext.fromTransport(request: TrainingUpdateRequest) {
    command = Command.UPDATE
    trainingRequest = request.training?.toInternal() ?: Training()
    environment = request.debug?.mode?.toEnv() ?: Environment.PROD
    trainingRequestStubs = request.debug?.stub?.toInternal()
}

fun TrainingContext.fromTransport(request: TrainingDeleteRequest) {
    command = Command.DELETE
    trainingRequest = request.training?.toInternal() ?: Training()
    environment = request.debug?.mode?.toEnv() ?: Environment.PROD
    trainingRequestStubs = request.debug?.stub?.toInternal()
}

fun TrainingContext.fromTransport(request: TrainingSearchRequest) {
    command = Command.SEARCH
    trainingFilterRequest = request.trainingFilter?.toInternal() ?: TrainingFilter()
    environment = request.debug?.mode?.toEnv() ?: Environment.PROD
    trainingRequestStubs = request.debug?.stub?.toInternal()
}

private fun TrainingSearchFilter.toInternal(): TrainingFilter {
    val userId = this.userId

    return TrainingFilter(
        searchString = this.searchString, userId = if (userId != null) UserId(userId.toUInt()) else null
    )
}

private fun TrainingReadObject.toInternal(): Training {
    val id = this.id
    val userId = this.userId

    return Training(
        id = if (id != null) TrainingId(id.toUInt()) else TrainingId.NONE,
        userId = if (userId != null) UserId(userId.toUInt()) else UserId.NONE,
    )
}

private fun TrainingDeleteObject.toInternal(): Training = Training(
    id = TrainingId(id.toUInt()),
)

private fun TrainingCreateObject.toInternal(): Training = Training(
    name = this.name, groupSlug = this.groupSlug, type = TrainingTypeId(this.type.toUInt()), date = this.date
)

private fun TrainingUpdateObject.toInternal(): Training = Training(
    name = this.name, groupSlug = this.groupSlug, type = TrainingTypeId(this.type.toUInt()), date = this.date
)

private fun TrainingRequestDebugStubs.toInternal(): TrainingRequestStubs = TrainingRequestStubs.fromString(this.value)

private fun TrainingRequestDebugMode.toEnv(): Environment = Environment.fromString(this.value) ?: Environment.PROD