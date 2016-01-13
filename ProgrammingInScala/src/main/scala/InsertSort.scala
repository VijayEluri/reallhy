
object InsertSort extends App {
  def sort[A](xs: List[A])(implicit c: A => Ordered[A]): List[A] = {
    for (i <- 1 until xs.length) {
      val temp = xs(i)
      val stream = Stream.from(i, -1).dropWhile(j => temp > xs(j) || j >= 0)

      stream.foreach(j => {
        if(temp < xs(j)){
          swap(xs, j, j + 1)
        }
      })

      if(stream.head > 0)
        xs.updated(stream.last - 1, temp)
    }
    xs
  }

  def swap[A](xs: List[A], i: Int, j: Int): Unit ={
    val tmp = xs(i)
    xs.updated(i, xs(j))
    xs.updated(j, tmp)
  }
}
