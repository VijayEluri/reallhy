import java.text._


object DateParserBoot extends App {
  implicit val date: String = "2014-12-03"

  object DateParser {
    def parse(implicit dateString: String) = new SimpleDateFormat("yyyy-MM-dd").parse(dateString)
  }

  println(DateParser.parse)

  class DateConverter(val s: String) {
    def toDateTime = DateParser.parse(s)
  }

  implicit def string2DateConverter(s: String) = new DateConverter(s)

  println(date.toDateTime)


  def calculateSignUp(implicit date: String) = {
    println("calculateSignUp : " + date)
  }

  calculateSignUp
}