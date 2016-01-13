object Main extends App {
  val arr = Array("a", "b", "c", "d")
  val res = for (a <- arr) yield a.toUpperCase
  println(res.mkString(","))

  class Simple(brand: String) {
    /**
     * 생성자
     */
    val color: String = if (brand == "TI") {
      "blue"
    } else if (brand == "HP") {
      "black"
    } else {
      "white"
    }

    // 인스턴스 메소드
    def add(m: Int, n: Int): Int = m + n
  }

  val calc = new Simple("SDS")
  println(calc.color)

  class Foo {}

  object FooMaker {
    def apply() = new Foo
  }

  val newFoo = FooMaker()
  println(newFoo)

  class Bar {
    def apply() = 0
  }

  val bar = new Bar
  println(bar())

  class Baz(foo: String)

  // companion object
  // new 없이 객체 생성
  object Baz {
    def apply(foo: String) = new Baz(foo)
  }

  println(Baz("hello"))


  object addOne extends Function1[String, Int] {
    def apply(m: String): Int = m.toInt + 1
  }

  println(addOne("1"))


  val times = 1
  times match {
    case 1 => "one"
    case 2 => "two"
    case _ => "some other number"
  }

  // 가드(조건문) 사용
  times match {
    case i if i == 1 => "one"
    case j if j == 2 => "two"
    case _ => "some other number"
  }

  def bigger(o: Any): Any = {
    o match {
      case i: Int if i < 0 => i - 1
      case i: Int => i + 1
      case d: Double if d < 0.0 => d - 0.1
      case d: Double => d + 0.1
      case text: String => text + "s"
    }
  }

  // new를 사용하지 않고 인스턴스 생성
  case class Calculator(brand: String, model: String) {
    def add(m: Int, n: Int) = m + n

    def close() = {}
  }

  val hp20b = Calculator("hp", "20b")
  val hp20B = Calculator("hp", "20b")
  println(hp20b == hp20B)

  def calcType(calc: Calculator) = calc match {
    case Calculator("hp", "20B") => "financial"
    case Calculator("hp", "48G") => "scientific"
    case Calculator("hp", "30B") => "business"
    //    case Calculator(ourBrand, ourModel) => "Calculator: %s %s is of unknown type".format(ourBrand, ourModel)
    case c@Calculator(_, _) => s"Calculator: $c is of unknown type"
  }

  println(calcType(Calculator("sds", "hello")))


  class ServerIsDownException extends RuntimeException {

  }

  object Logger {
    def error(e: Throwable, message: String): Unit = {
      println(s"$e.getMessage - $message")
    }
  }

  val remoteCalculatorService = Calculator("sds", "hellow")
  val log = Logger
  try {
    remoteCalculatorService.add(1, 2)
  } catch {
    case e: ServerIsDownException => log.error(e, "the remote calculator service is unavailble. should have kept your trustry HP.")
  } finally {
    remoteCalculatorService.close()
  }

  //Tuple
  val hostPort = ("localhost", 80)
  println(hostPort._1 +" = "+ hostPort._2)
  hostPort match {
    case ("localhost", port) => println(s"localhost:$port")
    case (host, port) => println(s"unknown host : $host, $port")
  }

  def squared(x: Double) = x * x

  println(List(1.1, 2.0, 3.2) map squared)
  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  // predicate에 따라 파티션 두 개로 나눔
  println(numbers.partition(_ % 3 == 0))

  // find는 조건을 만족하는 첫번째 원소 리턴
  println(numbers.find((i:Int) => i > 5))

  val list = List(Array("12", "15", "50"),Array("12", "0", "50"),Array("12", "10", "50"))
  list.filter(_(1).toInt > 5).foreach(x => print(x.mkString(",")))

  println


  val smallList= List(1,2,3,4)
  println(smallList.sliding(2,1).mkString(","))
}