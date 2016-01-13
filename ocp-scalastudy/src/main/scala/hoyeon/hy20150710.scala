package hoyeon

import java.io.{FileInputStream, PrintStream}

object hy20150710{
  System.setIn(new FileInputStream("practice/20150710/A-large-practice.in"))
  System.setOut(new PrintStream("practice/20150710/A-large-practice.out"))

  def main(args:Array[String]){
    (1 to readInt).map{t =>
      val (m,d,w) = readLine.split("\\s").map(_.toLong) match {case Array(m,d,w) => (m,d,w)}

      val lines = m * d / w + (m - (m * d / lcm(d, w)))
      (t, lines)
    }.foreach { case (t, result) => println("Case #%d: %d".format(t, result)) }
  }
  
  def gcd(a: Long, b: Long): Long = if(b == 0) a else gcd(b, a % b)

  def lcm(a: Long, b: Long): Long = a * b / gcd(a, b)
}