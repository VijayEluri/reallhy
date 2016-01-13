package week3.q3460

object Main {
  def main(args: Array[String]) {
    val t = readInt
    for (i <- 0 until t) {
      var n = readInt
      var j = 0
      while (n > 0) {
        if (n % 2 == 1) print(j + " ")
        n = n / 2
        j = j + 1
      }
      println
    }
  }
}

