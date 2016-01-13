import java.io.ByteArrayInputStream

object q2230 {
  val input = """3 3
                |1
                |5
                |3""".stripMargin
  System.setIn(new ByteArrayInputStream(input.getBytes()))

  def main(args: Array[String]) {
    val in = readLine.split(" ").map(_.toInt)
    val n = in(0)
    val m = in(1)
    val arr = (for (i <- 0 until n) yield readInt).par.toArray.sorted

    var minDiff = arr(n - 1) - arr(0)
    import scala.util.control.Breaks._
    breakable {
      for (i <- 0 until n - 1) {
        val j = arr.drop(i + 1).indexWhere(_ >= arr(i) + m)
        if (j == -1) break
        val diff = arr(j + i + 1) - arr(i)
        if (diff <= minDiff) {
          minDiff = diff
          if (minDiff == m) break
        }
      }
    }
    print(minDiff)
  }
}
