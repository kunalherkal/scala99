/*
Find the number of elements of a list.
Example:
  scala> length(List(1, 1, 2, 3, 5, 8))
res0: Int = 6
*/

val list = List(1, 1, 2, 3, 5, 8)
length1(list)
length2(list)

def length1[A](list: List[A]) : Int = {
  list.size
}

def length2[A](list: List[A]) : Int = {

  def loop(n: Int, list: List[A]) : Int = (n, list) match {
    case (a, Nil) => a
    case (a, head :: tail) => loop(a + 1, tail)
  }

  loop(0, list)
}