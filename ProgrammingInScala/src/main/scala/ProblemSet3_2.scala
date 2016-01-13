object ProblemSet3_2 extends App {

  def factorOut(input: Long): Long = {
    def stream(x: Long): Stream[Long] = x #:: stream(x + 1L)
    val factor: Long = stream(2L).filter(x => input % x == 0).takeWhile(_ <= input).head
    if (factor == input) input else factorOut(input / factor)
  }

  val result2 = factorOut(13195)
  println("result : " + result2)

  val result3 = factorOut(600851475143L)
  println("result : " + result3)
}
