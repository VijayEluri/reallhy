package week2

class Timber(woods:Array[Int]) {
  def maxCuttingHeight(m: Int, cut: Int = -1): Int = {
    val cutting = if(cut != -1) cut else woods.max
    val timber = woods.filter(_ > cutting).map(_ - cutting).sum
    if(timber >= m) cutting
    else maxCuttingHeight(m, cutting - 1)
  }

}
