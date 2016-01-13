import java.io.ByteArrayInputStream

object q9251 {
  System.setIn(new ByteArrayInputStream("ACAYKP\nCAPCAK".getBytes()))

  def main(args: Array[String]) {
    val first = readLine
    val second = readLine
    val arr = Array.fill[Array[Int]](first.length + 1)(Array.fill(second.length + 1)(0))
    for(i <- 1 to first.length){
      for(j <- 1 to second.length){
        if(first(i - 1) == second(j - 1))
          arr(i)(j) = arr(i - 1)(j - 1) + 1
        else
          arr(i)(j) = math.max(arr(i - 1)(j), arr(i)(j - 1))
      }
    }
    print(arr(first.length)(second.length))
  }
}
