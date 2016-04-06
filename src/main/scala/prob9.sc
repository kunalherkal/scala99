/*Pack consecutive duplicates of list elements into sublists.
If a list contains repeated elements they should be
placed in separate sublists.
Example:

scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd,
'e, 'e, 'e, 'e))
res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a),
List('b), List('c, 'c), List('a, 'a), List('d),
List('e, 'e, 'e, 'e))
*/
val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd,
  'e, 'e, 'e, 'e)

pack1(list)
pack2(list)

def pack1(list: List[Symbol]) : List[List[Symbol]] = {

  def loop(list1: List[Symbol]) : List[List[Symbol]] = list1 match {
    case Nil => Nil
    case head :: tail => {
      val fl = list1.takeWhile(a => a == head)
      val list2 = list1.dropWhile(a => a == head)
      fl :: loop(list2)
    }
  }

  loop(list)
}


def pack2(list: List[Symbol]) : List[List[Symbol]] = {

  def loop(formedList: List[List[Symbol]], list1: List[Symbol])
  : List[List[Symbol]] = list1 match {
    case Nil => formedList
    case head :: tail => {
      val fl = list1.takeWhile(a => a == head)
      val list2 = list1.dropWhile(a => a == head)
      loop(formedList :+ fl, list2)
    }
  }

  loop(Nil,list)
}