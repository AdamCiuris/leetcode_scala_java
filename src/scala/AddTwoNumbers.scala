package scala
/*
* Adam Ciuris
* Scala 3
* Solution to leetcode AddTwoNumbers
* nulls should be wrapped in an option, but I wont change the leetcode default list
* pure function
* TODO: refactor sum
*/
object AddTwoNumbers extends App {

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
    override def toString: String =
      next match {
        case null => s"$x"
        case _ => s"$x" + s"$next"
      }
  }
  // added third parameter to keep function pure
    def addTwoNumbers(l1: ListNode, l2: ListNode, carry: Int = 0): ListNode =
      (l1, l2) match {
        case(null, null) =>
          if (carry > 0) {
            ListNode(1)
          } else {
            null
          }
        case(null, l2) =>
          val sum:Int = l2.x +carry
          sum match {
            case sum if sum > 9 =>
              ListNode(sum % 10, addTwoNumbers(null, l2.next, 1))
            case _ => ListNode(sum, addTwoNumbers(null, l2.next))
          }
        case(l1, null) =>
          val sum:Int = l1.x+ +carry
          sum match {
            case sum if sum > 9 =>
              ListNode(sum % 10, addTwoNumbers(l1.next, null, 1))
            case _ => ListNode(sum, addTwoNumbers(l1.next, null))
          }
        case(l1, l2) =>
          val sum:Int = l1.x+l2.x +carry
          sum match {
            case sum if sum > 9 =>
                ListNode(sum % 10, addTwoNumbers(l1.next, l2.next, 1))
            case _ => ListNode(sum, addTwoNumbers(l1.next, l2.next))
        }
    }

}
