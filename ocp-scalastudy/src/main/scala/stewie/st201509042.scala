package stewie

import java.io.FileInputStream

import scala.util.Try

object st201509042 {

  System.setIn(new FileInputStream("practice/20150904/A-small-practice2.in"))

  def main(args: Array[String]) {


    (0 until 10) foreach { t =>

      try {
        val center =  readLine split " "  map(_.toInt)
        val cargo = readLine split " "  map(_.toInt)
        val result = if (Math.pow(center(2), 2) >= Math.pow(center(0) - cargo(0), 2) + Math.pow(center(1) - cargo(1), 2)) 1 else 0

        println(s"#$t $result")
      } catch {
        case e : Exception => return
      }

    }


  }
}
