/*
Find the Kth element of a list.
By convention, the first element in the list is element 0.
Example:

scala> nth(2, List(1, 1, 2, 3, 5, 8))
res0: Int = 2
* */


val list = List(1, 1, 2, 3, 5, 8)
nth1(3, list)
nth2(5, list)

//1 : Using the API
def nth1[A](n : Int, list: List[A]) : A = {
  val array = list.toArray
  array(n - 1)
}

//2 : Using the recursion
def nth2[A](n: Int, list: List[A]) : A = (n, list) match {
  case a if n > list.size => throw new IllegalArgumentException
  case (1, l) => l.head
  case (a, l) => nth2(a - 1, l.tail)
}