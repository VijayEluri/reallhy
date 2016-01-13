object PrimeNumber extends App{
  def isPrime(x: Int): Boolean = {
    val a = math.sqrt(x).toInt
    !(2 to a).exists(x % _ == 0)
  }
  println(Stream.from(2).filter(isPrime).take(10001).last)
}