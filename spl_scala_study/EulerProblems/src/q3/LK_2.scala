/**
 * Stream을 이용해서 풀었습니다.
 * 2부터 1씩 증분하는 Stream(2,3,4,5...)으로 input에 도달할 때까지 input에서 나누어지는 수를 구해서 첫번째 숫자를 구합니다.
 * factor가 input 과 같으면 (즉, input 보다 작은 값중에 더이상 나눠지는 값이 없으면 input을 리턴하고,
 * 그렇지 않으면, input을 factor로 나눈값으로 재귀호출합니다.
 *
 * @author Ho-yeon Lee, Jillian Kim
 */
object LK_2 extends App {

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
