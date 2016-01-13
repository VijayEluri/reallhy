import collection.mutable.Stack
import org.scalatest._

class InsertSortSpec extends FlatSpec with Matchers{

  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    stack.pop() should be (2)
    stack.pop() should be (1)
  }
/*
  "swap" should "change each other element in array" in {
    val list = List(1,5,6,2,0)
    InsertSort.sort(list)
    list should be (List(0,1,2,5,6))
  }*/
}
