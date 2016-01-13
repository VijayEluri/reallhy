import java.io.ByteArrayInputStream

import scala.collection.mutable.ArrayBuffer

object q2495 {
  System.setIn(new ByteArrayInputStream("""12345123
                                          |17772345
                                          |22233333""".stripMargin.getBytes()))

  def main(args: Array[String]) {
    for(i <- 0 until 3) {
      val line = readLine
      val buffer = Array.fill[Int](line.length)(0)
      var cnt = 1
      for(i <- 1 until line.length){
        if(line(i - 1) == line(i)) cnt += 1 else cnt = 1
        buffer(i) = cnt
      }
      println(buffer.max)
    }
  }
}