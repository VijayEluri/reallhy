import java.io.ByteArrayInputStream

object q1292 {
    System.setIn(new ByteArrayInputStream("3 7".getBytes()))

    def main(args: Array[String]) {
      val in = readLine.split(" ").map(_.toInt)
      val start = in(0)
      val end = in(1)
      // 1000 개짜리 배열 만들기
      var next = 1
      var count = 1
      val array = for(i <- 0 until 1000) yield{
        val result = next
        if(next == count) {
          next = next + 1
          count = 1
        } else {
          count = count + 1
        }
        result
      }
      println(array.drop(start - 1).take(end - start + 1).sum)
    }
  }