object SquareOfSumMinusSumOfSquare extends App{
  val range = (1 to 100)
  def sqr(x: Int) = x * x
  print(sqr(range.sum) - range.map(sqr).sum)
}

