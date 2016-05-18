/*Group the elements of a set into disjoint subsets.
a) In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons? Write a function that generates all the possibilities.
Example:

scala> group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David, Evi), List(Flip, Gary, Hugo, Ida)), ...
* */
val list = List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")
group3(list)

type grouped[A] = List[List[List[A]]]

def group3[A](list : List[A]): grouped[A] = {

  val firstGroup: List[List[A]] = combinations(2, list)

  val firstTwoGroup: grouped[A] = firstGroup.flatMap(l => {
    val remainingList = list.filter(l2 => !l.contains(l2))
    val nextCombinations: List[List[A]] = combinations(3, remainingList)
    nextCombinations.map(l2 => List(l, l2))
  })

  val allThreeGroups: grouped[A] = firstTwoGroup.map(l1 => {
    val flatList = l1.flatten
    val remainingList: List[A] = list.filter(l2 => !flatList.contains(l2))
    l1 :+ remainingList
  })

  allThreeGroups
}

def combinations[A](count: Int, list: List[A]) = {
  def combine(c: Int, list: List[A], formedList: List[A]): List[List[A]] = (c, list) match {
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

  higherCombine(list).distinct
}