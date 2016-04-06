import scala.collection.immutable.Range.Inclusive

/*
Decode a run-length encoded list.
Given a run-length code list generated as specified in problem P10,
construct its uncompressed version.
Example:

scala> decode(List((4, 'a), (1, 'b), (2, 'c),
(2, 'a), (1, 'd), (4, 'e)))
res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b,
'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
* */


val list = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))

decode1(list)

def decode1[A](list: List[(Int, A)]) : List[A] = {
  list.flatMap(a => getList(a._1, a._2))
}

def getList[A](n : Int, value: A) : List[A] = {
  (1 to n).toList.map(a => value)
}