package q4

object JL_2 extends App{
  val range = (999 to 100 by -1)
  val maxPalindrome = range.flatMap(x => range.map(y => x * y)).filter(z => z.toString.reverse.toInt == z).max
  println(maxPalindrome)
}