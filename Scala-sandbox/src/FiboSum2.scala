
object FiboSum2 extends App{
  var sum = 2
  def fibo(i:Int, j:Int):Int = {
    val k = i + j
    if(k > 4000000) return j
    if(k % 2 == 0) sum += k
    fibo(j, k)
  }
  fibo(1, 2)
  println(sum)
}
