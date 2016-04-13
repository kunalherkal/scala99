import scala.util.Random

/*
Extract a given number of randomly selected elements from a list.
Example:
scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
res0: List[Symbol] = List('e, 'd, 'a)
* */

//TODO This code has a bug where it can return list containing duplicate elements

val list = List('a, 'b, 'c, 'd, 'f, 'g, 'h)

randomSelect(3, list)

def randomSelect[A](a: Int, list: List[A]): List[A] = {
  for(v <- (1 to a).toList) yield {
    randomElement(list)
  }
}

def randomElement[A](list: List[A]): A = {
  list.drop(randomIndex(list.size)).head
}

def randomIndex(size: Int): Int = {
  val range = 1 until size
  val rnd = new Random
  range(rnd.nextInt(range.length))
}