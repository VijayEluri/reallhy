package week5

object Q9081 {
  def main(args: Array[String]) {
    System.setIn(Main.getClass.getResourceAsStream("input.txt"))
    val n = readInt
    for (i <- 0 until n) {
      val str = readLine.toCharArray
      // 맨뒤에서부터 앞 문자가 뒤 문자보다 작을때만 교환
      //
      // 다음 문자가 없으면 입력문자열 리턴
      var j = str.length - 1
      var flag = false;
      for(i <- str.length - 2 until 1 by -1 if !flag) {
        val a = str(i)
        val b = str(j)
        if (a < b) {
          flag = true
        } else {
          j = i - 2
        }
      }

      for(i <- str.length - 1 until 1 by -1 if(str(i) > str(j))) {
          val tmp = str(j)
          str(j) = str(i)
          str(i) = tmp
      }

      println(str.mkString)


    }
  }
}
