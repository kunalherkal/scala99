/*
Find out whether a list is a palindrome.
Example:
scala> isPalindrome(List(1, 2, 3, 2, 1))
res0: Boolean = true
*/

val list1 = List(1, 2, 3, 2, 1)
val list2 = List(2, 3, 2, 2)

isPalindrome1(list1)
isPalindrome1(list2)

def isPalindrome1[A](list: List[A]) : Boolean = list match {
  case Nil => true
  case a :: Nil => true
  case a :: b :: Nil => a == b
  case a :: tail if a == tail.last => isPalindrome1(tail.init)
  case a :: tail if a != tail.last => false
}