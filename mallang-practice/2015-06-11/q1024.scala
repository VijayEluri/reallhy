import java.io.ByteArrayInputStream

object q1024 {
  System.setIn(new ByteArrayInputStream( "3 3".getBytes()))

  def main(args: Array[String]) {
    val input = readLine.split("\\s").map(_.toInt)
    val n = input(0)
    var len = input(1)
    val max = 100
    var a = -1 // 연속된 수의 첫번째 숫자
    var m = (0 until len).sum // 0 + 1 + 2 ... len - 1 까지 더한 수
    while(len <= max && a <= -1) {
      // n = a  + (a + 1) + (a + 2) ....
      // n = len * a + (0 + 1 + 2 ... (len - 1))
      // n = len * a + m
      val mod = (n - m) % len
      if(mod == 0){
        a = (n - m) / len
      }
      m = m + len
      len = len + 1
    }
    print(if(a <= -1) "-1" else (a until a + len - 1).mkString(" "))
  }
}
