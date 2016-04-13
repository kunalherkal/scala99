/*
Insert an element at a given position into a list.
Example:
scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)
* */
val list = List('a, 'b, 'c, 'd)

insertAt1('new, 4, list)
insertAt2('new, 4, list)
insertAt3('new, 10, list)
insertAt2('new, 3, Nil)

def insertAt1[A](a: A, position: Int, list: List[A]): List[A] = {
  val l = list.splitAt(position)
  l._1 ++ List(a) ++ l._2
}

def insertAt2[A](a: A, position: Int, list: List[A]): List[A] = {

  def loop(index: Int, list: List[A]): List[A] =
    (index, list) match {
      case (i, l) if i > l.size => l :+ a
      case (i , l) if i > 0 => l.head :: loop(index - 1, l.tail)
      case (0, l) => a :: l
      case (_, Nil) => a :: Nil
  }

  loop(position, list)
}

def insertAt3[A](a: A, position: Int, list: List[A]): List[A] = {

  def loop(index: Int, list: List[A], formedList: List[A]): List[A] =
    (index, list) match {
      case (i, l) if i > l.size => l :+ a
      case (i , l) if i > 0 => loop(index - 1, l.tail, formedList :+ l.head)
      case (0, l) => formedList ++ List(a) ++ l
      case (_, Nil) => a :: Nil
    }

  loop(position, list, Nil)
}