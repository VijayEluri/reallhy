import org.scalatest._

class InsertSortSpec extends FlatSpec with Matchers {

  "swap" should "change each other element in array" in {
    val list = List(1, 5, 6, 2, 0)
    InsertSort.swap(list, 0, 1)
    list should be(List(1, 5, 6, 2, 0))
  }

  "sort" should "sort in a way of insert sort" in {
    val list = List(1, 5, 6, 2, 0)
    InsertSort.sort(list)
    list should be(List(0, 1, 2, 5, 6))
  }
}
