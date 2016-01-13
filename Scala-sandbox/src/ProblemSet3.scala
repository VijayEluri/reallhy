import scala.collection.mutable.ArrayBuffer

object ProblemSet3 extends App{

  def factorOut(x: Long): ArrayBuffer[Long] ={
    val result : ArrayBuffer[Long] = ArrayBuffer()
    var i: Long = 2
    while(i <= x){
      if(x % i == 0) {
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
