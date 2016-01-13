package kwangsun

object CalendarProblem {
  def solve(month:Int, dayOfMonth:Int, dayOfWeek:Int): Int = {
    val totalDay = month * dayOfMonth
    val totalWeek = totalDay / dayOfWeek
    
    val skip = totalDay / lcmOf(dayOfMonth, dayOfWeek)
    val numOfNewLine = month - skip
    
    totalWeek + numOfNewLine
  }
  
  def lcmOf(num1:Int, num2:Int) : Int = {
    num1 * num2 / BigInt(num1).gcd(num2).intValue
  }
}