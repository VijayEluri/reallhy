package q4

object JL extends App {
  // 수의 범위는 100*100이상(10000) 999*999(998001)이하이다
  // 숫자를 문자로 바꾼다음에 Reverse and check
  // 3자리 이상의 수로 나눈 나머지 0.

  def excutePalindrome(): Int = {
    Stream.from(999 * 999, -1).dropWhile(num => !(checkPalindronme(num) && checkDevideto3length(num))).head
  }

  def checkPalindronme(x: Int) = (x.toString == x.toString.reverse)

  def checkDevideto3length(x: Int) = {
    !Stream.from(999,-1).takeWhile(_ > 100).dropWhile(y => !(x % y == 0 && (x / y).toString.length == 3)).isEmpty
  }

  println(excutePalindrome())
}
