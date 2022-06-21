package scala

import scala.annotation.tailrec

/*
* Adam Ciuris
* Scala 3
* Solution to leetcode longest substring without repeating characters
* sliding window pattern
*/
object LongestSubstringWithoutRepeatingCharacters extends App {
  @tailrec
  def lengthOfLongestSubstring(s: String, start: Int = 0, end: Int = 0, map: Map[Char, Int], longest: Int = 0): Int = {
    if (end <= s.length-1) {
      val w = s.charAt(start)
      val charAt = s.charAt(end)
      map.get(charAt) match {
        case Some(e) =>
          val _start = e + 1 // move window to one position higher than index of prev char
          val _end = end + 1
          val _map = map.updated(charAt, end) // peculiar syntax change
          println(_end- start)
          lengthOfLongestSubstring(s, _start, _end, _map, longest)
        case None =>
          val _end = end + 1
          val _map: Map[Char, Int] = map + (charAt -> end)
          println(_end- start)
          val _longest = if longest < _end-start then end-start else 0
          lengthOfLongestSubstring(s, start, _end, _map, _longest)
      } // a b c d a e f
    }
    else
      longest+1 // add one to account for index 0 stuff

  }


  val myString1 = "abcabcbb" // 3
  val myString2 = "bbbbb" // 1
  val myString3 = "pwwkew" // 3
  val pls: Map[Char, Int] = Map()

  val test1 = lengthOfLongestSubstring(myString1, map=pls)
  val test2 = lengthOfLongestSubstring(myString2, map=pls)
  val test3= lengthOfLongestSubstring(myString3, map=pls)
  println(myString1 +" result: " + test1)
  println(myString2 +" result: " + test2)
  println(myString3 +" result: " + test3)

}
