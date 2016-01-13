package mihee

import java.io.FileInputStream

/**
 * Created by SDS on 2015-09-29.
 */

object mh20150929_04{
  System.setIn(new FileInputStream("practice/20150904_mh/A-small-practice_0929.in"))

  def main(args: Array[String]) {
    (1 to readInt).foreach { t =>
      val (n, m) = readLine.split(" ").map(_.toInt) match{case Array(n, m) => (n, m)}
      val mat = for (i <- 0 until n) yield readLine.split(" ")

      def check(row : Int, col : Int) = {
        mat(row)(col) = "A"
        val rLine=mat(row).filter(s => s!="0").mkString("")
        val transMat = mat.transpose
        val cLine = transMat(col).filter(s => s!="0").mkString("")
        mat(row)(col) = "T"
        if (rLine.indexOf("AG") != -1 || rLine.indexOf("GA") != -1 || cLine.indexOf("AG") != -1 || cLine.indexOf("GA") != -1) 1 else 0
      }

      val answer = mat.zipWithIndex.map { case(line, row) => line.zipWithIndex.map {case(cell, col) => if(cell=="T") {check(row, col)} else 0}.sum }.sum
      println("#%d %d".format(t, answer))
    }
  }
}