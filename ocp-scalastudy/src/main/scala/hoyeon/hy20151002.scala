package hoyeon

import java.io.FileInputStream

object hy20151002 {
  System.setIn(new FileInputStream("practice/20151002/A-small-practice.in"))

  def main(args: Array[String]) {
    (1 to readInt).foreach { t =>
      val (row, col) = readLine().split(" ").map(_.toInt) match { case Array(a, b) => (a, b) }
      val matrix = (0 until row).map(i => readLine().split(" "))

      // T : Target, G: Gunman, W : Wall
      def bang(cell: String, i: Int, j: Int): Boolean = {
        cell == "T" && {
          // 상하좌우 O가 아니고 처음 만나는 셀이 G 인 경우만 true, 나머진 false
          // 상
          var first = (i - 1 to 0 by -1).find(k => matrix(k)(j) != "O")
          if (first != None && matrix(first.get)(j) == "G") return true
          // 하
          first = (i + 1 until row).find(k => matrix(k)(j) != "O")
          if (first != None && matrix(first.get)(j) == "G") return true
          // 좌
          first = (j - 1 to 0 by -1).find(k => matrix(i)(k) != "O")
          if (first != None && matrix(i)(first.get) == "G") return true
          // 우
          first = (j + 1 until col).find(k => matrix(i)(k) != "O")
          if (first != None && matrix(i)(first.get) == "G") return true

          else false
        }
      }
      val res = matrix.zipWithIndex.map { case (line, i) =>
        line.zipWithIndex.count { case (cell, j) => bang(cell, i, j) }
      }.sum
      println(s"#$t $res")
    }
  }
}
