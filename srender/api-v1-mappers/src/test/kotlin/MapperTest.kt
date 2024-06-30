import com.otus.otuskotlin.srender.api.v1.models.*
import com.otus.otuskotlin.srender.commonMain.TrainingContext
import com.otus.otuskotlin.srender.commonMain.core.Environment
import com.otus.otuskotlin.srender.commonMain.models.TrainingId
import com.otus.otuskotlin.srender.commonMain.models.TrainingRequestStubs
import com.otus.otuskotlin.srender.commonMain.models.UserId
import com.otus.otuskotlin.srender.fromTransport
import junit.framework.TestCase.assertEquals
import org.junit.Test

class MapperTest {
    @Test
    fun fromTransportCreate() {
        val req = TrainingCreateRequest(
            debug = TrainingDebug(
                mode = TrainingRequestDebugMode.STUB,
                stub = TrainingRequestDebugStubs.SUCCESS,
            ),
            training = TrainingCreateObject(
                groupSlug = "my-programmers-command",
                name = "Спринтовые учения по отключению ДЦ Sprint 1",
                type = 11,
                date = "2024-06-11",
            ),
        )

        //When
        val context = TrainingContext()
        context.fromTransport(req)

        //Then
        assertEquals(TrainingRequestStubs.SUCCESS, context.trainingRequestStubs)
        assertEquals(Environment.STUB, context.environment)
        assertEquals("Спринтовые учения по отключению ДЦ Sprint 1", context.trainingRequest.name)
        assertEquals("my-programmers-command", context.trainingRequest.groupSlug)
        assertEquals(TrainingId.NONE, context.trainingRequest.id)
        assertEquals("2024-06-11", context.trainingRequest.date)
    }

    @Test
    fun fromTransportUpdate() {
        val req = TrainingUpdateRequest(
            debug = TrainingDebug(
                mode = TrainingRequestDebugMode.STUB,
                stub = TrainingRequestDebugStubs.SUCCESS,
            ),
            training = TrainingUpdateObject(
                groupSlug = "my-programmers-command",
                name = "Спринтовые учения по отключению ДЦ Sprint 1",
                type = 11,
                date = "2024-06-11",
            ),
        )

        //When
        val context = TrainingContext()
        context.fromTransport(req)

        //Then
        assertEquals(TrainingRequestStubs.SUCCESS, context.trainingRequestStubs)
        assertEquals(Environment.STUB, context.environment)
        assertEquals("Спринтовые учения по отключению ДЦ Sprint 1", context.trainingRequest.name)
        assertEquals("my-programmers-command", context.trainingRequest.groupSlug)
        assertEquals(TrainingId.NONE, context.trainingRequest.id)
        assertEquals("2024-06-11", context.trainingRequest.date)
    }

    @Test
    fun fromTransportDelete() {
        val req = TrainingDeleteRequest(
            debug = TrainingDebug(
                mode = TrainingRequestDebugMode.STUB,
                stub = TrainingRequestDebugStubs.SUCCESS,
            ),
            training = TrainingDeleteObject(
                id = 11,
                lock = "123",
            ),
        )

        //When
        val context = TrainingContext()
        context.fromTransport(req)

        //Then
        assertEquals(TrainingId(11U), context.trainingRequest.id)
    }

    @Test
    fun fromTransportRead() {
        val req = TrainingReadRequest(
            debug = TrainingDebug(
                mode = TrainingRequestDebugMode.STUB,
                stub = TrainingRequestDebugStubs.SUCCESS,
            ),
            training = TrainingReadObject(
                id = 11,
                userId = 123,
            ),
        )

        //When
        val context = TrainingContext()
        context.fromTransport(req)

        //Then
        assertEquals(TrainingId(11U), context.trainingRequest.id)
        assertEquals(UserId(123U), context.trainingRequest.userId)
    }

    @Test
    fun fromTransportSearch() {
        val req = TrainingSearchRequest(
            debug = TrainingDebug(
                mode = TrainingRequestDebugMode.STUB,
                stub = TrainingRequestDebugStubs.SUCCESS,
            ),
            trainingFilter = TrainingSearchFilter(
                searchString = "Search string",
                userId = 123,
            ),
        )

        //When
        val context = TrainingContext()
        context.fromTransport(req)

        //Then
        assertEquals("Search string", context.trainingFilterRequest.searchString)
        assertEquals(UserId(123U), context.trainingFilterRequest.userId)
    }
}