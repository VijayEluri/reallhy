package week2

import scala.collection.mutable._

class WordStudy(str: String) {
  def countLetters(): Array[(String, Int)] = {
    val map = Map[String, Int]()
    str.toLowerCase.map(_ + "").foreach { k =>
      if(!map.contains(k)) {
        map.put(k, 0)
      }
      map.put(k, map.get(k).get + 1)
    }
    map.toArray.sortBy{case (k, v) => v}.reverse
  }

  def findMostAppearedLetter(array: Array[(String, Int)]): String ={
    if(array.length > 1) {
      val v1 = array(0)._2
      val v2 = array(1)._2
      if(v1 == v2) return "?"
    }
    array(0)._1
  }
}
