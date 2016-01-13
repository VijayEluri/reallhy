package projecteuler

object Problem001 extends App {

  def sumOfMultiple(n : Int):Int = {
    var num = 1
    var sum = 0
    for(curnum <- num.until(1000)) {
      if( curnum % 3 == 0 || curnum % 5 == 0 ) {
        sum += curnum
      }
    }
    sum
  }

  println(sumOfMultiple(1000));



  def sumOfMultWithRecursive(n : Int):Int = sumOfMultWithRecursiveUnit(n-1)
  def sumOfMultWithRecursiveUnit(n: Int):Int = {
    if( n <= 0 ) return 0;
    {if( n%3==0 || n%5==0 ) n else 0}  + sumOfMultWithRecursiveUnit(n-1)
  }

  println(sumOfMultWithRecursive(1000));

}