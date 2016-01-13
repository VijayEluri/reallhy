import scala.collection.immutable.List

object ImplicitSum extends App{

  abstract class SemiGroup[A] {
    def add(x: A, y: A) : A
  }

  abstract class Monoid[A] extends SemiGroup[A] {
    def unit: A
  }

  implicit object stringMonoid extends Monoid[String] {
    def add(x: String, y: String): String = x.concat(y)
    def unit:String = ""
  }

  implicit object intMonoid extends Monoid[Int] {
    def add(x:Int, y:Int): Int = x + y
    def unit:Int = 0
  }

  def sum[A](xs: List[A])(m:Monoid[A]): A = {
    if(xs.isEmpty) m.unit
    else m.add(xs.head, sum(xs.tail)(m))
  }
  println(sum(List(1,2,3,4,5))(intMonoid))
  println(sum(List("a","b","c","d","e"))(stringMonoid))

  def isum[A](xs:List[A])(implicit m: Monoid[A]): A = {
    if(xs.isEmpty) m.unit
    else m.add(xs.head, isum(xs.tail))
  }
  println(isum(List(1,2,3,4,5)))
}
