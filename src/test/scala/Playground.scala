import org.junit.Test

def cutter[A](n: Integer): List[A] => (List[A], List[A]) =
  (l: List[A]) => (l.take(2), l.drop(2))

def condition[A](n: Integer): List[A] => Boolean =
  (l: List[A]) => (l.length >= n)

def f[A](
    cond: List[A] => Boolean,
    c: List[A] => (List[A], List[A])
): List[A] => List[List[A]] = {
  def fm(l: List[A]): List[List[A]] = {
    if (cond(l)) {
      val (ls: List[A], rest: List[A]) = c(l)
      ls :: fm(rest)
    } else List.empty
  }
  fm
}

class Playground {
  @Test def playground(): Unit = {
    val chunk_by = (lst) => f(condition(2), cutter(2))(lst)
    println(chunk_by(List(1, 2, 3)))
    println(chunk_by(List(1, 2, 3, 4, 5)))
  }
}
