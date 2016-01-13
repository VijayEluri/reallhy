package mihee

import java.io.FileInputStream

import scala.util.Try

/**
 * Created by SDS on 2015-09-24.
 */

object mh20150924_08 {
  System.setIn(new FileInputStream("practice/20150904_mh/A-small-practice_0924.in"))

  def main(args: Array[String]) {
    (1 to readInt).foreach { t =>
      val (n, m, tester) = readLine.split(" ").map(_.toInt) match{case Array(n, m, tester) => (n, m, tester)}
      var answer = 0
      val matrix = for (i <- 0 until n) yield readLine.split(" ").map(_.toInt)

      (1 to tester).foreach { tester =>
        answer +=start()
      }

      def start() : Int= {
        val (x, y, totalCnt) = readLine.split(" ").map(_.toInt) match {case Array(x, y, totalCnt) =>  (x, y, totalCnt)}
        move(x-1,y-1,totalCnt, 1)
      }

      def move(x :Int, y : Int, totalCnt : Int, currCnt:Int) :Int = {
        var reward = 0
        val direction = matrix(x)(y) / 10
        val mvCnt = matrix(x)(y) % 10

        val newX = direction match{
          case 2 => x+mvCnt
          case 4 => x-mvCnt
          case _ => x
        }
        val newY = direction match{
          case 1 => y+mvCnt
          case 3 => y-mvCnt
          case _ => y
        }

        if(newX<0 || newX >= n || newY <0 || newY >=m){
          reward = -1000
        }else if(currCnt < totalCnt){
          reward = move(newX, newY, totalCnt, currCnt+1)
        }else if(currCnt == totalCnt){
          reward = matrix(newX)(newY)*100 - 1000
        }
        return reward
      }

      println("#%d %d".format(t, answer))
    }
  }
}