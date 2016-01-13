object FiboEvenSum extends App{
    val fibo : Stream[Int] = 1 #:: 2 #:: fibo.zip(fibo.tail).map(n => n._1 + n._2)
    val result = fibo.takeWhile(_ <= 4000000).filter(_ % 2 == 0).sum
    println(result)
}
