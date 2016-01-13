import java.io.ByteArrayInputStream

object q1334 {
  System.setIn(new ByteArrayInputStream("132234232546635234562345234524353".getBytes()))

  def main(args: Array[String]) {
    val line = readLine
    val input = line.map(_ - 48).toArray
    val output = line.map(_ - 48).toArray
    val len = input.length
    val mid = len / 2
    for(i <- 0 until mid){
      output(len - i - 1) = input(i)
    }
    var result = BigInt(output.mkString)
    if(result <= BigInt(input.mkString)) {
      result += BigInt("1"+ "0" * mid)
      val arr = result.toString.map(_ - 48).toArray
      val len2 = arr.length
      val mid2 = len2 / 2
      for(i <- 0 until mid2){
        arr(len2 - i - 1) = arr(i)
      }
      result = BigInt(arr.mkString)
    }
    print(result)
  }
}