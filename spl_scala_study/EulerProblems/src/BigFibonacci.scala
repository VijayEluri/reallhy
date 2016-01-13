
object BigFibonacci extends App{
  /*def mul(A, B) = {
    a,b,c = A
    d,e,f = B
    return a*d+b*e, a*e+b*f, b*e+c*f
  }
  def pow(A, n) = {
    if(n == 1) return A
    if(n & 1 == 0) return pow(mul(A, A), n/2)
    else return mul(A, pow(mul(A, A), (n-1)/2))
  }

  def fib(n:BigInt) : BigInt = {
    if(n<2) return n
    pow((1,1,0), n-1)[0]
  }*/

  def fib(n:BigInt):BigInt = {
    fibo_iter(n, 0, 1)
  }

  def fibo_iter(x:BigInt, a:BigInt, b:BigInt): BigInt ={
    if(x == 0) a
    else fibo_iter(x-1, b, a + b)
  }

  println(fib(BigInt(1000000)))
}
