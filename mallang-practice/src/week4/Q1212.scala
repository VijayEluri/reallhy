package week4

object Q1212 {
  def main(args: Array[String]) {
    System.setIn(Q1212.getClass.getResourceAsStream("input-1212.txt"))
    val num = readLine
    val result = num.map(n => {
      var m = (n - '0')
      var k = ""
      for (i <- 1 to 3) {
        k = (m % 2) + k
        m = m / 2
      }
      k
    }).mkString.dropWhile(_ == '0')
    println(result)
  }
}