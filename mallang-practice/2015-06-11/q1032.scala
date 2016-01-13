import java.io.ByteArrayInputStream

object q1032 {
  System.setIn(new ByteArrayInputStream( """3
                                           |config.sys
                                           |config.inf
                                           |configures
                                         """.stripMargin.getBytes()))

  def main(args: Array[String]) {
    val n = readInt
    val files = (0 until n).map { x => readLine }
    val len = files(0).length
    val pattern = (for (i <- 0 until len) yield {
      files.map(file => file(i)).reduce{ (a, b) => if (a == b) b else '?' }
    }).mkString
    println(pattern)
  }
}
