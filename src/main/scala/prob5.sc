/*
Reverse a list.
Example:
scala> reverse(List(1, 1, 2, 3, 5, 8))
res0: List[Int] = List(8, 5, 3, 2, 1, 1)
* */

val list = List(1, 1, 2, 3, 5, 8)
reverse1(list)
reverse2(list)


def reverse1[A](list: List[A]) : List[A] = {
  list.reverse
}

def reverse2[A](list: List[A]) : List[A] = {

  def loop(formedList : List[A], originalList: List[A]) : List[A]
  = (formedList, originalList) match {
    case (a, Nil) => a
    case (a, head :: tail) => loop(head :: a, tail)
  }

  loop(Nil: List[A], list)
}