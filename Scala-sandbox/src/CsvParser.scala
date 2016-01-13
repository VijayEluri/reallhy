
object CsvParser extends App{
  val line = readLine().split(",")
  line.zipWithIndex.foreach(t => println(f"${t._2}%02d\t${t._1}%20s"))

}
