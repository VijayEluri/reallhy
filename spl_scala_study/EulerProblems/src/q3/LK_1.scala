
import scala.collection.mutable.ArrayBuffer

/**
 * 2부터 1씩 증분하면서 input을 나눌수 있는 인자를 만나면 결과 ArrayBuffer에 인자를 추가하고,
 * input을 factor로 나눈값으로 재귀호출해서 결과를 ArrayBuffer에 추가합니다.
 * input을 나눌 수 있는 수가 없으면 빈 ArrayBuffer를 리턴합니다.
 * 결과는 ArrayBuffer에 있는 값 중 max 값입니다.
 *
 * @author Ho-yeon Lee, Jillian Kim
 */
object LK_1 extends App {

  def factorOut(x: Long): ArrayBuffer[Long] = {
    val result: ArrayBuffer[Long] = ArrayBuffer()
    var i: Long = 2
    while (i <= x) {
      if (x % i == 0) {
        result += i
        return result ++= factorOut(x / i)
      }
      i += 1
    }
    result
  }

  val result1 = factorOut(13195)
  println(result1.max)

  val result2 = factorOut(600851475143L)
  println(result2.max)

}
