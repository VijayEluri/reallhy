package projecteuler

object Problem003 extends App {
  def isPrimeFactor(n : Long) : Boolean = {
    for( i <- 2 to (n/2).toInt ) {
  	  if( n % i == 0 ) {
	  	return false
  	  }
    }
    return true
  }                                         //> isPrimeFactor: (n: Long)Boolean
 
  println(isPrimeFactor(4))
  
  
  def largestPrimeFactor(n : Long) : Int = {
  	for( i <- (2 to Math.sqrt(n).toInt).reverse ) {
  		if( n%i == 0 && isPrimeFactor(i) )  {
  			return i
  		}
  	}
  	return 1
  }
  
  largestPrimeFactor(13195)                       //> res0: Int = 29
  largestPrimeFactor(600851475143l)               //> res1: Int = 6857
  
}