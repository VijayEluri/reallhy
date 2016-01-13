package week2

import scala.math._

class Turrets(turret1: (Int, Int, Int), turret2: (Int, Int, Int)) {

  def distanceBetweenTurrets(): Double = {
    val x1: Int = turret1._1
    val x2: Int = turret2._1
    val y1: Int = turret1._2
    val y2: Int = turret2._2
    sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2))
  }

  def countTarget(): Double = {
    val d = distanceBetweenTurrets()
    val r1 = turret1._3
    val r2 = turret2._3
    val sum = r1 + r2
    val diff = abs(r1 - r2)
    if (d == 0 && r1 == r2) -1
    else if (sum > d && diff < d) 2
    else if (sum == d || diff == d) 1
    else 0
  }

  def main(args: Array[String]) {

  }
}
