/*
Generate the combinations of K distinct objects chosen from
the N elements of a list.
In how many ways can a committee of 3 be chosen from
a group of 12 people? We all know that there are
C(12,3) = 220 possibilities
(C(N,K) denotes the well-known binomial coefficient).
For pure mathematicians, this result may be great.
But we want to really generate all the possibilities.
Example:

scala> combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
res0: List[List[Symbol]] =
List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), ...
* */
val list = List('a, 'b, 'c, 'd, 'e, 'f)
combinations(3, list).size
combinations(3, list).foreach(println)
def combinations[A](count: Int, list: List[A]) = {
  def combine(c : Int, list: List[A], formedList: List[A])
  : List[List[A]] = (c, list) match {
    case (1, l) => l.map(a => formedList ++ List(a))
    case (_, Nil) => List(formedList)
    case (_, _) => combine(c - 1, list.tail, formedList :+ list.head)
  }
  def middleCombine(list: List[A]): List[List[A]] = {
    (0 to (list.size - count)).toList.flatMap(a => combine(count, list.head :: list.drop(a + 1), Nil))
  }
  def higherCombine(list: List[A]) =  {
    (0 to list.size - count).flatMap(a => middleCombine(list.drop(a))).toList
  }
  higherCombine(list)
}

