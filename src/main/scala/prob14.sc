/*
Duplicate the elements of a list.
Example:
scala> duplicate(List('a, 'b, 'c, 'c, 'd))
res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
* */

val list = List('a, 'b, 'c, 'c, 'd)

duplicate1(list)
duplicate2(list)
duplicate3(list)

def duplicate1[A](list: List[A]) : List[A] = {
  list.flatMap(a => List(a, a))
}

def duplicate2[A](list: List[A]) : List[A] = list match {
  case Nil => Nil
  case head :: tail => head :: head :: duplicate2(tail)
}


def duplicate3[A](list: List[A]) : List[A] = {

  def loop[A](formedList: List[A], list: List[A]): List[A] = list match {
    case Nil => formedList
    case head :: tail => loop(formedList :+ head :+ head, tail)
  }

  loop(Nil, list)
}