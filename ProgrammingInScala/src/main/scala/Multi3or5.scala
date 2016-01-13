object Multi3or5 extends App{
  println((0 until 1000 by 3).union(0 until 1000 by 5).distinct.sum)
}
