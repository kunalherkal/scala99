/*
Modified run-length encoding.
Modify the result of problem P10 in such a way that
if an element has no duplicates it is simply copied into
the result list.
Only elements with duplicates are transferred as (N, E) terms.

Example:

scala> encodeModified(List('a, 'a, 'a, 'a, 'b,
'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
* */
val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd,
  'e, 'e, 'e, 'e)
encodeModified1(list)

def encodeModified1[A](list: List[A]) : List[Any] = {
  val list1 = pack2(list).map(a => (a.size, a.head))

  list1.map(a => a match {
    case (1, b) => b
    case b => b
  })
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