import org.junit.Test

def cutter[A](n: Integer): List[A] => (List[A], List[A]) =
  (l: List[A]) =>
    if (l.length >= n) (l.take(n), l.drop(n))
    else (List.empty, List.empty)

def f[A](
    c: List[A] => (List[A], List[A]),
    l: List[A]
): List[List[A]] = {
  val (ls: List[A], rest: List[A]) = c(l)
  if (ls.isEmpty) List.empty else ls :: f(c, rest)
}

class Playground {
  @Test def playground(): Unit = {
    val chunk_by = lst => f(cutter(2), lst)
    println(chunk_by(List(1, 2, 3)))
    println(chunk_by(List(1, 2, 3, 4, 5)))
  }
}
