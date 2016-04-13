/*
Remove the Kth element from a list.
Return the list and the removed element in a Tuple.
Elements are numbered from 0.
Example:

scala> removeAt(1, List('a, 'b, 'c, 'd))
res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
* */

val list = List('a, 'b, 'c, 'd)

removeAt(2, list)

def removeAt[A](index: Int, list: List[A]): (List[A], A) = {
  val sList = list.take(index) ++ list.drop(index + 1)
  val value = list.drop(index).take(1).head
  (sList, value)
}
