import java.io.ByteArrayInputStream


object q6588 {
  val input = """6
                |10
                |30
                |42
                |999998
                |0""".stripMargin
  System.setIn(new ByteArrayInputStream(input.getBytes()))

  // 값이 1인 인덱스만 prime
  val primes = {
    val arr = Array.fill(1000000)(1)
    val threshold = math.sqrt(arr.length).toInt //1000
    for (i <- 2 to threshold if (arr(i) == 1)) {
      for (j <- i * 2 until arr.length by i) {
        arr(j) = 0
      }
    }
    arr(0) = 0
    arr(1) = 0
    arr(2) = 0
    arr
  }

  def main(args: Array[String]) {
    for(n <- io.Source.stdin.getLines.map(_.toInt)){
      if (n == 0) return
      var found = false
      for (a <- 3 to n / 2 by 2 if (!found && (primes(a) == 1))) {
        val b = n - a
        if (b % 2 == 1 && primes(b) == 1) {
          println("%d = %d + %d".format(n, a, b))
          found = true
        }
      }
      if (!found) println("Goldbach's conjecture is wrong.");
    }
  }
}
