object Q1110 {
  def main(args: Array[String]) {
    var n = readInt
    val m = n
    var cnt = 0
    do {
      n = 10 * (n % 10) + ((n / 10 + n % 10) % 10)
      cnt = cnt + 1
    } while(n != m)
    println(cnt)
  }
}