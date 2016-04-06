/*
Run-length encoding of a list.
  Use the result of problem P09 to implement
  the so-called run-length encoding data compression method.
  Consecutive duplicates of elements are encoded as
  tuples (N, E) where N is the number of duplicates of the element
   E.
Example:

  scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a,
  'a, 'd, 'e, 'e, 'e, 'e))
res0: List[(Int, Symbol)] =
List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

*/


val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd,
  'e, 'e, 'e, 'e)

encode1(list)

def encode1[A](list: List[A]) : List[(Int, A)] = {
    pack2(list).map(a => (a.size, a.head))
}


def pack2[A](list: List[A]) : List[List[A]] = {

  def loop(formedList: List[List[A]], list1: List[A])
  : List[List[A]] = list1 match {
    case Nil => formedList
    case head :: tail => {
      val fl = list1.takeWhile(a => a == head)
      val list2 = list1.dropWhile(a => a == head)
      loop(formedList :+ fl, list2)
    }
  }

  loop(Nil,list)
}