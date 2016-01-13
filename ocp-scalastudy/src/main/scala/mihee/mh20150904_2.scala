package mihee

import java.io.FileInputStream

/**
 * Created by SDS on 2015-09-04.
 */

object mh20150904_2 {
  System.setIn(new FileInputStream("practice/20150904_mh/A-small-practice_2.in"))

  def main(args: Array[String]) {
    (1 to readInt).foreach { t =>
      val (a, b, r) = readLine.split(" ").map(_.toInt) match {case Array(a, b, r) => (a, b, r)}
      val (x, y) = readLine.split(" ").map(_.toInt) match {case Array(x, y) => (x, y)}
      val result = (x-a) * (x-a) + (y-b)*(y-b)

      val answer =
        if(result <= r*r) 1
        else 0
      println("#%d %d".format(t, answer))
    }
  }
}