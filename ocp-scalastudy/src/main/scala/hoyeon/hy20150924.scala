package hoyeon

import java.io.FileInputStream

import scala.util.control.Breaks._

object hy20150924 {
  System.setIn(new FileInputStream("practice/20150924/A-small-practice.in"))

  def main(args: Array[String]) {
    (1 to readInt).foreach { t =>
      val (n, i, j, p) = readLine().split(" ").map(_.toInt) match {
        case Array(a, b, c, d) => (a, b, c, d)
      }
      val pitfalls = readLine().split(" ").map(_.toInt).sliding(2, 2).map { case Array(a, b) => (a, b) }
      val d = readInt()
      // (방향, 이동칸수)
      val advices = readLine().split(" ").map(_.toInt).sliding(2, 2)
      def getDirection(k: Int): (Int, Int) = {
        k match {
          case 1 => (-1, 0)
          case 2 => (-1, 1)
          case 3 => (0, 1)
          case 4 => (1, 1)
          case 5 => (1, 0)
          case 6 => (1, -1)
          case 7 => (0, -1)
          case 8 => (-1, -1)
        }
      }
      // 출발지 (i,j). 전체 판은 (1, 1) ~ (n, n)
      var pos = (i, j)
      breakable {
        advices.foreach { advice =>
          for (m <- 1 to advice(1)) { // 이동칸수
            val direction = getDirection(advice(0)) // 방향
            pos = (pos._1 + direction._1, pos._2 + direction._2)
            if (pitfalls.contains(pos) || pos._1 < 1 || pos._1 > n || pos._2 < 1 || pos._2 > n) {
              pos = (0, 0)
              break
            }
          }
        }
      }
      println(s"#$t ${pos._1} ${pos._2}")
    }
  }
}
