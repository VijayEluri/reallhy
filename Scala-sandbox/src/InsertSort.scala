
object InsertSort extends App {
  def sort[A](xs: List[A])(implicit c: A => Ordered[A]): List[A] = {
    for (i <- 1 until xs.length) {
      val temp = xs(i)

    }
    xs
  }

  def swap(xs: List[Int], i: Int, j: Int): Unit ={
    val tmp = xs(i)
    xs.updated(i, xs(j))
    xs.updated(j, tmp)
  }
}
