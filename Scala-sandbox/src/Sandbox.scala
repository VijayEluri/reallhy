
object Sandbox extends App{
  val symbols = Array("<", "-", ">");
  val counts = Array(2, 10)
  val pairs = symbols.zip(counts)
  println(pairs.mkString)
}
