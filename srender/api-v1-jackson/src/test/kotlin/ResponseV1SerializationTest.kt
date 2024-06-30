import com.otus.otuskotlin.srender.api.v1.apiV1Mapper
import com.otus.otuskotlin.srender.api.v1.models.*
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class ResponseV1SerializationTest {
    private val response = TrainingCreateResponse(
        training = TrainingResponseObject(
            groupSlug = "my-programmers-command",
            name = "Спринтовые учения по отключению ДЦ Sprint 1",
            type = 11,
            date = "2024-06-11",
            userId = 7
        )
    )

    @Test
    fun serialize() {
        val json = apiV1Mapper.writeValueAsString(response)

        assertContains(json, Regex("\"groupSlug\":\\s*\"my-programmers-command\""))
        assertContains(json, Regex("\"name\":\\s*\"Спринтовые учения по отключению ДЦ Sprint 1\""))
        assertContains(json, Regex("\"type\":\\s*11"))
        assertContains(json, Regex("\"date\":\\s*\"2024-06-11\""))
        assertContains(json, Regex("\"userId\":\\s*7"))
    }

    @Test
    fun deserialize() {
        val json = apiV1Mapper.writeValueAsString(response)
        val obj = apiV1Mapper.readValue(json, IResponse::class.java) as TrainingCreateResponse

        val resWithType = response.copy(responseType = "create")
        assertEquals(resWithType, obj)
    }
}