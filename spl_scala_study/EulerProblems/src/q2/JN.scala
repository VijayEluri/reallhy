package projecteuler

object Problem002 extends App {

	def evenSumOfFibonacci(max : Int) : Int = evenSumOfFibonacciUnit(1,2,max)
	def evenSumOfFibonacciUnit(first : Int, second : Int, max : Int) : Int = {
		if ( first >= max ) return 0;
		{if( first%2==0 ) first else 0} + evenSumOfFibonacciUnit(second, first+second, max)
	}

	println(evenSumOfFibonacci(4000000));



	// 이호연 프로님 솔루션
	val fibo : Stream[Int] = 1 #:: 2 #:: fibo.zip(fibo.tail).map(n => n._1 + n._2)
	val result = fibo.takeWhile(_ <= 4000000).filter(_ % 2 == 0).sum
	println(result)
}