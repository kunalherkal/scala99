/*
Eliminate consecutive duplicates of list elements.
If a list contains repeated elements they should be replaced with a single copy
of the element. The order of the elements should not be changed.
Example:

scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
* */
val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
compress1(list)
compress2(list)


def compress1[A](list: List[A]) : List[A] = list match {
  case Nil => Nil
  case head :: tail => head :: compress1(tail.dropWhile(a => a == head))
}

def compress2[A](list: List[A]) : List[A] = {

  def loop[A](formedList : List[A], list: List[A]) : List[A] = list match {
    case Nil => formedList ::: Nil
    case head :: tail => loop(formedList :+ head, tail.dropWhile(a => a == head))
  }

  loop(Nil, list)
}