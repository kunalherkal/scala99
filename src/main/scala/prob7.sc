/*
Flatten a nested list structure.
Example:
scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
res0: List[Any] = List(1, 1, 2, 3, 5, 8)
* */

val list: List[Any] = List(List(1, 1), 2, List(3, List(5, 8)))
flatten(list)

def flatten(list: List[Any]) : List[Any] = {
  list.flatMap(element => element match {
    case a : Int => List(a)
    case b : List[Any] => flatten(b)
  })
}


