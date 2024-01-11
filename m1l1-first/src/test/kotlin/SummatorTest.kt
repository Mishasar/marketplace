import ru.otus.otuskotlin.marketplace.m1l1.Summator
import kotlin.test.Test
import kotlin.test.assertEquals

class SummatorTest {
    @Test
    fun sumTest() {
        val summator = Summator()
        assertEquals(3, summator.sum(1, 2))
    }
}
