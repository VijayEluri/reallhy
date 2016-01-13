
object MergeSort extends App{
  def sort[A] (xs: List[A]) (implicit c: A => Ordered[A]) : List[A] =  {
    if(xs.isEmpty || xs.tail.isEmpty) xs
    else{
      val (ys, zs) = xs.splitAt(xs.length / 2)
      merge(sort(ys), sort(zs))
    }
  }

  def merge[A](xs: List[A], ys: List[A])(implicit c: A => Ordered[A]): List[A] = {
    if(xs.isEmpty) ys
    else if(ys.isEmpty) xs
    else if(xs.head < ys.head) xs.head :: merge(xs.tail, ys)
    else ys.head :: merge(xs, ys.tail) (c)
  }

  print(sort(List(3,5,1,2,6)).mkString(","))
}
