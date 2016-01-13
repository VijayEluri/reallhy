package q2

/**
 * 1과 2부터 시작해서 피보나치 수열을 만드는 함수를 재귀호출합니다.
 * 마지막 두 수를 더한 다음 수가 4000000을 넘으면 마지막 숫자를 리턴합니다.
 * sum 변수에 다음 수가 짝수인 경우에만 더해줍니다.
 * sum 이 결과값입니다.
 *
 * @author GK. Song, Ho-yeon Lee
 */
object SL_1 extends App{
  var sum = 2
  def fibo(i:Int, j:Int):Int = {
    val k = i + j
    if(k > 4000000) return j
    if(k % 2 == 0) sum += k
    fibo(j, k)
  }
  fibo(1, 2)
  println(sum)
}
