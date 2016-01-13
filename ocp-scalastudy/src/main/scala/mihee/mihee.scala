package mihee

/**
 * Created by SDS on 2015-07-13.
 */
object mihee extends App {

  def main(args: Array[Int]): Int = {
    val m : Int = args(0)
    var mdays : Int = args(1)
    val wdays: Int = args(2)
    var mok : Int = 0
    var residual : Int  = 0
    var result : Int = 0
    for(i<-0 until m) {
      mdays += residual
      mok = mdays / wdays
      residual = mdays % wdays
      result += mok
      if (residual > 0) { result += 1 }
    }
    result
  }
}
