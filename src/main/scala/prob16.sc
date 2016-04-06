/*
Drop every Nth element from a list.
Example:
scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
* */


val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
drop(3, list)

def drop[A](n: Int, list: List[A]) : List[A] = {

  def loop(count: Int, list1: List[A]) : List[A] = (count, list1) match {
    case (0, _) => throw new IllegalArgumentException
    case (a, Nil) => Nil
    case (a, l) if count == n => loop(1, l.tail)
    case (a, l) => l.head :: loop(a + 1, l.tail)
  }

  loop(1, list)

}