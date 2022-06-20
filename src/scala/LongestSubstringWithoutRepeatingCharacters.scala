package scala

import scala.annotation.tailrec

/*
* Adam Ciuris
* Scala 3
* Solution to leetcode longest substring without repeating characters
*
*/
object LongestSubstringWithoutRepeatingCharacters extends App {
  @tailrec
  def lengthOfLongestSubstring(s: String, start: Int = 0, end: Int = 0, map: Map[Char, Int]): Int = {

    val w = s.charAt(start)

    val _map: Map[Char, Int] = map + (w -> 1)

    val _start = start+1
//    val _end = s
    println(map)
    println(_map)
    if start != end-1 then
    lengthOfLongestSubstring(s,_start, end,_map) else 9

  }

  val myString = "pwwkew"
  val pls: Map[Char, Int] = Map('p' -> 0)

  val yes = lengthOfLongestSubstring(myString, end=myString.length, map=pls)

}
