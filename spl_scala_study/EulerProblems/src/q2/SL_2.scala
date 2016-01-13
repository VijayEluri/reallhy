package q2

/**
 * Fibonacci 수열을 표현하는 Stream을 준비합니다.
 * Stream의 마지막 두 숫자를 zip해서 Tuple을 만든 다음, 두 숫자를 더한 숫자를 다음 수로 정합니다.
 * 수열의 마지막 수가 4000000을 넘기전에 짝수인 수만 필터링해서 합계를 구합니다.
 * @author GK. Song, Ho-yeon Lee
 */
object SL_2 extends App{
  val fibo : Stream[Int] = 1 #:: 2 #:: fibo.zip(fibo.tail).map(n => n._1 + n._2)
  val result = fibo.takeWhile(_ <= 4000000).filter(_ % 2 == 0).sum
  println(result)
}
