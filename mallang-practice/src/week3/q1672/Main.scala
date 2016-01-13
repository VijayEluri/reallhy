package week3.q1672

object Main {
  def main(args: Array[String]) {
    val len = readInt
    val str = readLine
    val axis = Array('A','G','C','T')
    val table = Array(Array('A','C','A','G'),Array('C','G','T','A'),Array('A','T','C','G'),Array('G','A','G','T'))
    var merged = str(len - 1)
    for(i <- len - 2 to 0 by -1){
      merged = table(axis.indexOf(str(i)))(axis.indexOf(merged))
    }
    print(merged)
  }
}
