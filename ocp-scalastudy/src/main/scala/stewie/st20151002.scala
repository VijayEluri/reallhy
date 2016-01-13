package stewie

import java.io.FileInputStream

import scala.util.Try

object st20151002 {

  System.setIn(new FileInputStream("practice/20151002/A-small-practice.in"))

  def main(args: Array[String]) {

    (1 to readInt()).foreach { t =>

      val firstLine = readLine().split(" ").map(_.toInt)
      val rowCount = firstLine(0)
      val colCount = firstLine(1)
      val matrix = for (i <- 0 until rowCount) yield readLine.split(" ")

      val rtnVal = for (row <- 0 until rowCount; col <- 0 until colCount; cell = matrix(row)(col))
        yield if (cell == "T" && existT(matrix, row, col)) 1 else 0

      println(s"#$t ${rtnVal.sum}")
    }

    def existT(line: Seq[Array[String]], i: Int, j: Int): Boolean = {

      val verticalLine = line.map(_(j)).mkString("")
      val horizontalLine = line(i).reduce(_ + _)

      return Try(horizontalLine.substring(0, j).reverse.replace("O", "").startsWith("G")).getOrElse(false) ||
        Try(horizontalLine.substring(j + 1).replace("O", "").startsWith("G")).getOrElse(false) ||
        Try(verticalLine.substring(0, i).reverse.replace("O", "").startsWith("G")).getOrElse(false) ||
        Try(verticalLine.substring(i + 1).replace("O", "").startsWith("G")).getOrElse(false)
    }
  }
}
