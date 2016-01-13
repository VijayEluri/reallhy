import scala.math

object MaxPrimeDivide extends App {
  val x = 600851475143L
  val leftDivides = (2 to math.sqrt(x).toInt).filter(x % _.toLong == 0)
  val rightDivides = leftDivides.map(x / _.toLong toInt)
  val maxPrimeDivide = leftDivides.union(rightDivides).filter(n => !(2 until n).exists(m => n % m == 0)).max
  println(maxPrimeDivide)
}
