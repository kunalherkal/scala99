/*
Split a list into two parts.
The length of the first part is given. Use a Tuple for your result.
Example:

scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: (List[Symbol], List[Symbol])
= (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
* */
val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
split1(5, list)
split2(5, list)

//Recursive
def split1[A](n: Int, list: List[A]) : List[List[A]] = {

  def loop[A](n: Int, list: List[A]) : List[List[A]] = (n, list) match {
    case (n, l) if n > 0 && n < list.size => list.take(n) :: loop(0, list.drop(n))
    case _ => List(list)
  }

  loop(n, list)
}

//Recursive
def split2[A](n: Int, list: List[A]) : List[List[A]] = {

  def loop[A](n: Int, list: List[A], formedList: List[List[A]]) : List[List[A]] = (n, list) match {
    case (n, l) if n > 0 && n < list.size =>  loop(0, list.drop(n), List(list.take(n)))
    case _ => formedList :+ list
  }

  loop(n, list, Nil)
}
