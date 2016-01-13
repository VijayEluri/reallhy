object Palindrome extends App{
  val range = (999 to 100 by -1)
  val maxPalindrome = range.map(x => range.map(y => x * y)).flatten.filter(z => z.toString.reverse.toInt == z).max
  println(maxPalindrome)
}