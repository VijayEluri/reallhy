package hoyeon

import java.io.FileInputStream

import scala.util.Try

object hy20150904_2 {
  System.setIn(new FileInputStream("practice/20150904/A-small-practice2.in"))

  def main(args: Array[String]) {
    val testcases = 3
    (1 to testcases).foreach { t => //테스트케이스 수
      val (cx, cy, r) = readLine.split(" ").map(_.toInt) match {
        case Array(cx, cy, r) => (cx, cy, r)
      }
      val (sx, sy) = readLine.split(" ").map(_.toInt) match {
        case Array(sx, sy) => (sx, sy)
      }
      val result = if ((sx - cx) * (sx - cx) - (sy - cy) * (sy - cy) > r * r) 0 else 1
      println("#%d %s".format(t, result))
    }
  }
}