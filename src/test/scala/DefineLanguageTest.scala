import hauska.DefineLanguage.define_language
import org.junit.Test
import org.junit.Assert.*

class DefineLanguageTest {
  @Test def t1(): Unit =
    assertEquals("class L0", define_language("L0"))
}
