package mihee

import java.io.FileInputStream
import scala.util.Try

/**
 * Created by SDS on 2015-09-04.
 */

object mh20150904 {
  System.setIn(new FileInputStream("practice/20150904_mh/A-small-practice.in"))

  def main(args: Array[String]) {
    (1 to readInt).foreach { t =>
      val n = readInt
      var answer = 0
      val matrix = Array.ofDim[String](n, n)
      for (i <- 0 until n) matrix.update(i, readLine.split(" "))
      for (row <- 1 until n-1) {
        for (col <-1 until n-1) {
          if (matrix(row)(col) == "B") {
            Try(
              if (matrix(row)(col - 1) == "B" && matrix(row)(col + 1) == "B" && matrix(row - 1)(col) == "B" && matrix(row + 1)(col) == "B"){
                for(subC<-1 to n-1){
                  if(matrix(row)(subC) == "B")
                    answer += 1
                }
                for(subR<-1 to n-1){
                  if(matrix(subR)(col) == "B" && subR != row)
                    answer += 1
                }
              }
              else{
                answer += 1
              }
            )
          }
        }
      }
      println("#%d %d".format(t, answer))
    }
  }
}