package hoyeon

import java.io.{FileInputStream, PrintStream}

import scala.util.Try

object hy20150827 {
  System.setIn(new FileInputStream("practice/20150827/A-small-practice.in"))
  def main(args: Array[String]) {
    (1 to readInt).foreach { t => //테스트케이스 수
      val n = readInt() //row 수
      val matrix = for (i <- 0 until n) yield readLine.split(" ") //matrix 생성
      for (row <- 0 until n; col <- 0 until n; cell = matrix(row)(col)){
        val span = cell match { case "A" => 1 case "B" => 2 case "C" => 3 case _ => 0 }
        for (k <- 1 to span; hop = 1 * k)   //기지국 동서남북 커버 표시(A:1, B:2, C:3)
          Seq((0, -hop), (0, hop), (hop, 0), (-hop, 0)).foreach {
            case (x, y) => Try(if (matrix(row + x)(col + y) == "H") matrix(row + x)(col + y) = "X")
          }
      }
      val result = matrix.map(row => row.count(_ == "H")).sum //남은 집 카운팅
      println("#%d %d".format(t, result))
    }
  }
}