import org.junit.Test
import org.junit.Assert.*
import hauska._

class Test1 {
  @Test def t1(): Unit =
    assertEquals("I was compiled by Scala 3. :)", msg)

  @Test def t2(): Unit =
    assertEquals("hello", hauska())
}
