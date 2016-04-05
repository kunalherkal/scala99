/*Find the last but one element of a list.
  Example:
  scala> penultimate(List(1, 1, 2, 3, 5, 8))
res0: Int = 5
*/

val list1 = List(1, 1, 2, 3, 5, 8)
val list2 = List(5, 8)
val list3 = List(3, 8)

penultimate1(list1)
penultimate2(list1)
penultimate3(list1)

penultimate1(list2)
penultimate2(list2)
penultimate3(list2)

penultimate1(list3)
penultimate2(list3)
penultimate3(list3)

//1 : Using the API
def penultimate1[A](list: List[A]) : A = {
  list.init.last
}

//2 : Using the tail recursion
def penultimate2[A](list: List[A]) : A = list match {
  case a :: b :: Nil => a
  case a :: tail => penultimate2(tail)
  case _  => throw new NoSuchElementException
}

//3 : Using foldleft
def penultimate3[A](list: List[A]) : A = list match {
  case Nil => throw new NoSuchElementException
  case a :: Nil => throw new NoSuchElementException
  case _ =>

  list.init.last
}