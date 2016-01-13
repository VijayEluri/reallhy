import java.io.ByteArrayInputStream

object q1208 {
  val input = """5 0
                |-7 -3 -2 5 8""".stripMargin
  System.setIn(new ByteArrayInputStream(input.getBytes()))

  def main(args: Array[String]) {
    val (n, k) = readLine.split("\\s").map(_.toInt) match { case Array(a, b) => (a, b) }
    val arr = readLine.split("\\s").map(_.toInt)

    val cnt = Iterator.iterate(1L){_ + 1L}.takeWhile(_ < (1L << n)).map { i =>
      val partSum = (0 until n).filter(j => (i & (1 << j)) == (1 << j)).map(j => arr(j)).sum
      if(partSum == k) 1 else 0
    }.sum
    print(cnt)
  }
}
