//package scala

import scala.annotation.tailrec
/*
* Adam Ciuris
* Scala 3
* Solution to leetcode RomanToInt
* pure
* static map
*/
object RomanToInteger extends App {
  val Roman: Map[String, Int] = Map("M" -> 1000, "D" -> 500,
                                  "C" -> 100, "L" -> 50,
                                  "X" -> 10,
                                  "V" -> 5, "I" -> 1)
  @tailrec
  def romanToInt(s: String, _s:String= "",i: Int=0, sum: Int = 0): Int = {
    if (i >= s.length) {
      sum
    } else {
      val s_ = s.substring(s.length - i - 1, s.length-i) // sliding window of one
//      val _s = s.substring(s.length - i)
      val pre = Roman.getOrElse(s_, 0)
      val post = Roman.getOrElse(_s, 0)
      pre < post match {  // WORLD'S MOST UNNECESSARY PATTERN MATCH
        case true =>
          val _sum = sum - pre
          romanToInt(s,s_ ,i + 1, _sum)
        case false =>
          val _sum = sum + pre
          romanToInt(s,s_, i + 1, _sum)
      }
    }
  }
  val res1 = romanToInt("V")
  val res2 = romanToInt("VII")
  val res3 = romanToInt("M")
  val res4 = romanToInt("IV")
  println(res1)
  println(res2)
  println(res3)
  println(res4)

}
