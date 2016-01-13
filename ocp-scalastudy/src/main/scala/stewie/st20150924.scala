package stewie

import java.io.FileInputStream

object st20150924 {

  System.setIn(new FileInputStream("practice/20150924/A-small-practice.in"))

  def main(args: Array[String]) {

    (1 to readInt()).foreach { t =>

      val line = readLine().split(" ").map(x => x.toInt)
      val maxNum = line(0)
      var position = (line(1), line(2))
      val traps = toTupleList(readLine().split(" ").map(x => x.toInt).toList)
      readInt()
      val directions = toTupleList(readLine().split(" ").map(x => x.toInt).toList)

      for (directionTuple <- directions if position !=(0, 0)) {
        position = calc(directionTuple._1, directionTuple._2, position, traps, maxNum)
      }

      println(s"#$t ${position._1} ${position._2}")

    }

    def calc(direction: Int, steps: Int, position: (Int, Int), traps: List[(Int, Int)], maxNum: Int): (Int, Int) = {
      val nextPosition = direction match {
        case 1 => (position._1 - steps, position._2)
        case 2 => (position._1 - steps, position._2 + steps)
        case 3 => (position._1, position._2 + steps)
        case 4 => (position._1 + steps, position._2 + steps)
        case 5 => (position._1 + steps, position._2)
        case 6 => (position._1 + steps, position._2 - steps)
        case 7 => (position._1, position._2 - steps)
        case 8 => (position._1 - steps, position._2 - steps)
      }
      return if (traps.contains(nextPosition) || nextPosition._1 <= 0 || nextPosition._2 <= 0 || nextPosition._1 >
        maxNum || nextPosition._2 > maxNum) (0, 0) else nextPosition
    }

    def toTupleList(l: List[Int]): List[(Int, Int)] = l match {
      case Nil => Nil
      case a :: b :: rest =>
        Pair(a, b) :: toTupleList(rest)
    }
  }
}
