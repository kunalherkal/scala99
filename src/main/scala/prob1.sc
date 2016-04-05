/*Find the last element of a list.
Example:
scala> last(List(1, 1, 2, 3, 5, 8))
res0: Int = 8
* */
val list = List(1, 1, 2, 3, 5, 8)
last1(list)
last2(list)
last3(list)

//Way 1 : Using the API
def last1[A](list: List[A]): A = {
  list.last
}

//Way2 : Tail recursion
def last2[A](list: List[A]) : A = list match {
  case a :: Nil => a
  case a :: tail => last2(tail)
  case _ => throw new IllegalArgumentException
}

//Way3 : foldleft
def last3[A](list: List[A]) : A = list match {
  case Nil => throw new NoSuchElementException
  case _ => list.foldRight(list.head) ( (res, e) => res
  )
}

//def sum(list: List[Int]): Int = list.foldLeft(0)((r,c) => r+c)