import kotlin.test.Test
import kotlin.test.assertEquals

class FunctionsTest {
    @Test
    fun simpleFun() {
        val param = 0.1
        val expected = param * param
        assertEquals(expected, simple(param))
    }

    @Test
    fun defaultArgs() {
        assertEquals("New people: Ivan, Ivanov", createPeople("Ivan"))
    }

    @Test
    fun namedArgs() {
        val res = createPeople("Ivan")
        assertEquals("Ivan", res)
    }

    @Test
    fun extensions() {
        assertEquals(
            "This is string!This is suffix!",
            "This is string!".addSuffix("This is suffix!")
        )
    }
}

private fun simple(x: Double): Double = x * x

private fun createPeople(name: String, secondName: String = "Ivanov") = "New people: $name, $secondName"

private fun String.addSuffix(suffix: String) = this.plus(suffix)
