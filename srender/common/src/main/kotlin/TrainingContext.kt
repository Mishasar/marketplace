package com.otus.otuskotlin.srender.commonMain

import com.otus.otuskotlin.srender.commonMain.core.Command
import com.otus.otuskotlin.srender.commonMain.core.Environment
import com.otus.otuskotlin.srender.commonMain.core.RequestId
import com.otus.otuskotlin.srender.commonMain.core.State
import com.otus.otuskotlin.srender.commonMain.models.Training
import com.otus.otuskotlin.srender.commonMain.models.TrainingFilter
import com.otus.otuskotlin.srender.commonMain.models.TrainingRequestStubs
import kotlinx.datetime.Instant

data class TrainingContext(
    var command: Command = Command.NONE,
    var state: State = State.NONE,
    val errors: MutableList<Error> = mutableListOf(),
    var environment: Environment = Environment.PROD,
    var requestId: RequestId = RequestId.NONE,
    var timeStart: Instant = Instant.NONE,

    var trainingRequest: Training = Training(),
    var trainingFilterRequest: TrainingFilter = TrainingFilter(),
    var trainingRequestStubs: TrainingRequestStubs? = null,

    var trainingResponse: Training = Training(),
    var trainingsResponse: MutableList<Training> = mutableListOf(),
)
