package stewie

import java.io.FileInputStream

import scala.util.Try

object st201509041 {

  System.setIn(new FileInputStream("practice/20150904/A-small-practice.in"))

  def main(args: Array[String]) {
    (1 to readInt()).foreach { t =>

      val n = readInt()
      val matrix = Array.ofDim[String](n, n)
      for (i <- 0 until n) matrix.update(i, readLine().split(" "))
      var totalHeight = 0
      for (row <- 0 until n) {
        for (col <- 0 until n) {
          if (matrix(row)(col) == "B") {
            totalHeight += calcHeightForB(matrix, row, col, n)
          }
        }
      }
      println(s"#$t $totalHeight")
    }
  }

  def calcHeightForB(matrix: Array[Array[String]], row: Int, col: Int, maxCount: Int): Int = {

    Try(if (matrix(row)(col - 1) == "G") return 1)
    Try(if (matrix(row)(col + 1) == "G") return 1)
    Try(if (matrix(row - 1)(col) == "G") return 1)
    Try(if (matrix(row + 1)(col) == "G") return 1)

    (0 until maxCount).map { x => (if (matrix(x)(col) == "B") 1 else 0) + (if (matrix(row)(x) == "B") 1 else 0)}.sum - 1
  }

}
