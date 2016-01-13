object Main {
  def main(args:Array[String]) {
    val n = readInt
    for(i <- 0 until n){
      val a = readInt
      val b = a + a.toString.reverse.toInt + ""
      println(if (b == b.reverse) "YES" else "NO")
    }
  }
}
