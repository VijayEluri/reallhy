package week4

object Q1110 {
  def main(args: Array[String]) {
    System.setIn(Q1110.getClass.getResourceAsStream("input-1110.txt"))
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