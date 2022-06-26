package scala
import scala.annotation.tailrec


/*
* Adam Ciuris
* Scala 3
* Solution to leetcode longest substring without repeating characters
* sliding window pattern
* TODO: fix
*/
object LongestSubstringWithoutRepeatingCharacters extends App {


  @tailrec
  def lengthOfLongestSubstring(s: String, start: Int = 0, end: Int = 0, map: Map[Char, Int], longest: Int = 0): Int = {
    if (end <= s.length-1 ) {
      val w = s.charAt(start)
      val charAt = s.charAt(end)
      map.get(charAt) match {
        case Some(e) =>

          val _longest = longest + 1
//          val _map = map.updated(charAt, end) // peculiar syntax change
//          val _map = map()
          val _map: Map[Char, Int] = Map()
          val _start = e + 1 // move window to one position higher than index of prev char
          val _end = end + 1
          if (start >= e+1) {
            val _longest = if longest < end-start then end-start else longest
            //                      println(_end- start + "" + charAt)
            lengthOfLongestSubstring(s, _start, _end, _map, _longest)
          } else {
            val _longest = if longest < end-start then end-start else longest
            lengthOfLongestSubstring(s, _start, _end, _map, _longest)
          }
        case None =>

          val _map: Map[Char, Int] = map + (charAt -> end)
          //          println(_end- start)
          val _current = end - start
          val _longest = if longest < _current then _current else longest
          //          println(";ljakdfs" + _longest)
          val _end = end + 1
          lengthOfLongestSubstring(s, start, _end, _map, _longest)
      } // a b c d a e f
    }
    else
      longest // add one to account for index 0 stuff

  }
  val myString1 = "abcabcbb" // 3
  val myString2 = "bbbbb" // 1
  val myString3 = "pwwkew" // 3
  val myString4 = "ckilbkd" // 5
  val myString5 = "nfpdmpi" // 5
  val myString6 = "tmmzuxt" // 5
  val myString7 = "abba" // 2
  val myString8 = "aabaab!bb" // 2
  val pls: Map[Char, Int] = Map()

  val test1 = lengthOfLongestSubstring(myString1, map=pls)
  val test2 = lengthOfLongestSubstring(myString2, map=pls)
  val test3= lengthOfLongestSubstring(myString3, map=pls)
  val test4= lengthOfLongestSubstring(myString4, map=pls)
  val test5= lengthOfLongestSubstring(myString5, map=pls)
  val test6= lengthOfLongestSubstring(myString6, map=pls)
  val test7= lengthOfLongestSubstring(myString7, map=pls)
  val test8= lengthOfLongestSubstring(myString8, map=pls)
  println(myString1 +" result: " + test1)
  println(myString2 +" result: " + test2)
  println(myString3 +" result: " + test3)
  println(myString4 +" result: " + test4)
  println(myString5 +" result: " + test5)
  println(myString6 +" result: " + test6)
  println(myString7 +" result: " + test7)
  println(myString8 +" result: " + test8)

}
