package hoyeon

import java.io.FileInputStream

import scala.util.Try

object hy20150904_1 {
  System.setIn(new FileInputStream("practice/20150904/A-small-practice.in"))

  def main(args: Array[String]) {
    (1 to readInt).foreach { t => //테스트케이스 수
      val n = readInt() //row 수
      val matrix = for (i <- 0 until n) yield readLine.split(" ")
      def nearGreenZone(row: Int, col: Int): Boolean = {
        val directions = Array((0, 1), (0, -1), (1, 0), (-1, 0))
        directions.exists{ case (i, j) => Try(matrix(row + i)(col + j) == "G").getOrElse(false) }
      }
      def countCrossedBuildings(row: Int, col: Int): Int = {
        matrix(row).count(_ == "B") + (for (i <- 0 until n) yield matrix(i)(col)).count(_ == "B") - 1
      }
      //빌딩의 높이 : 상하좌우가 G이면 B의 높이는 1, 아니면 같은 열/행에 있는 빌딩 수
      val totalHeight = matrix.zipWithIndex.map { case (line, row) =>
        line.zipWithIndex.map { case (cell, col) =>
          if (cell == "G") 0 else if (nearGreenZone(row, col)) 1 else countCrossedBuildings(row, col)
        }.sum
      }.sum
      println(s"#$t $totalHeight")
    }
  }
}