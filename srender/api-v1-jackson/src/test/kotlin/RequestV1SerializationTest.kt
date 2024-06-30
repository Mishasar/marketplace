import com.otus.otuskotlin.srender.api.v1.apiV1Mapper
import com.otus.otuskotlin.srender.api.v1.models.*
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class RequestV1SerializationTest {
    private val request = TrainingCreateRequest(
        training = TrainingCreateObject(
            groupSlug = "my-programmers-command",
            name = "Спринтовые учения по отключению ДЦ Sprint 1",
            type = 11,
            date = "2024-06-11",
        )
    )

    @Test
    fun serialize() {
        val json = apiV1Mapper.writeValueAsString(request)

        assertContains(json, Regex("\"groupSlug\":\\s*\"my-programmers-command\""))
        assertContains(json, Regex("\"name\":\\s*\"Спринтовые учения по отключению ДЦ Sprint 1\""))
        assertContains(json, Regex("\"type\":\\s*11"))
        assertContains(json, Regex("\"date\":\\s*\"2024-06-11\""))
    }


    @Test
    fun deserialize() {
        val json = apiV1Mapper.writeValueAsString(request)
        println(json)
        val obj = apiV1Mapper.readValue(json, IRequest::class.java) as TrainingCreateRequest

        val reqWithType = request.copy(requestType = "create")
        assertEquals(reqWithType, obj)
    }

    @Test
    fun deserializeNaked() {
        val jsonString = """
            {"training": null}
        """.trimIndent()
        val obj = apiV1Mapper.readValue(jsonString, TrainingCreateRequest::class.java)

        assertEquals(null, obj.training)
    }
}