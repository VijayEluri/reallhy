package EulerProblem

// Question 4. A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
// Find the largest palindrome made from the product of two 3-digit numbers.

object NS extends App {

  val NINE = 999
  val ZERO = 100
  
  def maxPalindromeNumber():Int = {
    val max = NINE*NINE
    val min = ZERO*ZERO
    for ( num <- max to min by - 1 ) {
      if( isPalindrome(num.toString) && canDivide(num)) {
          return num
      }
    }
    return -1
  }
  
  def canDivide(num:Int):Boolean = {
    for( i <- NINE to ZERO by -1) {
      if( num%i == 0 && num/i < NINE) {
        println(i + "*" + num/i)
        return true
      }
    }
    return false
  }
  
  def isPalindrome(p:String):Boolean= {    
    for ( i <- 0 to p.length()/2 ) {
      if ( p(i) != p(p.length - 1- i) ) return false
    }
    return true
  }
  
  println(maxPalindromeNumber)
}