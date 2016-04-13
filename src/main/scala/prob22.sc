/*
Create a list containing all integers within a given range.
Example:
scala> range(4, 9)
res0: List[Int] = List(4, 5, 6, 7, 8, 9)
* */
range1(4, 9)
//range1(30, 9)
def range1(lower: Int, upper: Int) : List[Int] = {
  if(lower < upper){
    val r = lower to upper
    r.toList }
  else Nil
}
