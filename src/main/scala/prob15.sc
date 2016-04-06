/*Duplicate the elements of a list a given number of times.
Example:
scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b,
'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)*/



val list = List('a, 'b, 'c, 'c, 'd)

duplicateN1(3, list)
duplicateN2(3, list)
duplicateN3(3, list)

def duplicateN1[A](n: Int, list: List[A]) : List[A] = {
  list.flatMap(a => (1 to n).toList.map(_ => a))
}

def duplicateN2[A](n: Int, list: List[A]) : List[A] = list match {
  case Nil => Nil
  case head :: tail => (1 to n).toList.map(_ => head) ::: duplicateN2(n, tail)
}


def duplicateN3[A](n: Int, list: List[A]) : List[A] = {

  def loop(formedList: List[A], list: List[A]): List[A] = list match {
    case Nil => formedList
    case head :: tail => loop(formedList ::: (1 to n).toList.map(_ => head), tail)
  }

  loop(Nil, list)
}