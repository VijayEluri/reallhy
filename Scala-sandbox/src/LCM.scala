object LCM extends App {
  def gcd(a: Long, b: Long): Long = if (a == b) a else gcd((a - b).abs, a);
  println((1L to 20L).fold(1L)((x, y) => x * y / (gcd(x, y))))
}