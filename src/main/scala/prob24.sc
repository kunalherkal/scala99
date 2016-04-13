import scala.util.Random

/*
Draw N different random numbers from the set 1..M.
Example:
scala> lotto(6, 49)
res0: List[Int] = List(23, 1, 17, 33, 21, 37)
* */

//TODO This code has a bug where it can return list containing duplicate elements

lotto(6, 20)

def lotto(count: Int, upperLimit: Int) : List[Int] = {
  randomSelect(count, (0 to upperLimit).toList)
}

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