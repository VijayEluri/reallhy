package q1

/**
  * 0부터 1000까지 3씩 증가하는 Range와 5씩 증가하는 Range를 합치고,
 *  중복되는 부분을 없앤 다음(distinct), 각 값들을 합쳤습니다.
  *
  * @author GK. Song, Ho-yeon Lee
  */
object SL extends App{
  val result = (0 to 1000 by 3).union(0 to 1000 by 5).distinct.sum
  println(result)
 }
