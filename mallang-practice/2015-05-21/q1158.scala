import java.io.ByteArrayInputStream

object q1158 {
  System.setIn(new ByteArrayInputStream("7 3".getBytes()))

  def main(args: Array[String]) {
    val in = readLine.split(" ").map(_.toInt)
    val n = in(0)
    val m = in(1)
    val arr = (1 to n).toArray
    val res = Array.fill[Int](n)(0)
    var next = 0
    for (i <- 0 until n) {
      var j = 0
      while (j < m) {
        if (next == n) next = 0
        if (arr(next) != 0) {
          j = j + 1
        }
        next = next + 1
      }
      res(i) = next
      arr(next - 1) = 0
    }
    print(res.mkString("<", ", ", ">"))
  }
}