import java.io.ByteArrayInputStream

/** 문제
  * 지민이는 N쪽인 책이 한권 있다. 첫 페이지는 1쪽이고, 마지막 페이지는 N쪽이다. 각 숫자가 모두 몇 번이 나오는지 출력하는 프로그램을 작성하시오.

  * 입력
  * 첫째 줄에 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.

  * 출력
  * 첫째 줄에 0이 총 몇 번 나오는지, 1이 총 몇 번 나오는지, ..., 9가 총 몇 번 나오는지를 출력한다.  *
  */
object q1019 {
  System.setIn(new ByteArrayInputStream("11".getBytes()))

  def main(args: Array[String]) {
    val n = readInt
    val numbers = Array.fill[Int](10)(0)

    // 1부터 n까지 숫자 세기(bruteforce)
    (1 to n).foreach(i => {
      var tmp = i
      while (tmp > 0) {
        val m = tmp % 10
        numbers(m) = numbers(m) + 1
        tmp = tmp / 10
      }
    })
    print(numbers.mkString(" "))
  }
}