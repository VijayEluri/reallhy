package jungho

import java.io.{PrintStream, FileOutputStream, FileInputStream, ByteArrayInputStream}

object jh20150727 {
  val input = """3
                |4 O 2 B 1 B 2 O 4
                |3 O 5 O 8 B 100
                |2 B 2 B 1""".stripMargin
//  System.setIn(new ByteArrayInputStream(input.getBytes()))
  System.setIn(new FileInputStream("practice/20150727/A-small-practice.in"))
//  System.setOut(new PrintStream(new FileOutputStream("practice/20150727/A-small-practice.out")))
  def main(args: Array[String]) {
    val tests = readInt
    for(t <- 1 to tests) {
      val arr = readLine.split(" ")
      val n = arr(0).toInt
      val sequence = arr.drop(1)

      var oPos = 1
      var bPos = 1
      var oNext = 0
      var bNext = 0

      // find next o, b position
      // ex. o 2 b 1 b 2 o 4
      var currentSequence = 0
      var time = 0
      for(i <- 1 to n){
        // get next position o, b
        var oTmpPos = currentSequence * 2
        while(oTmpPos < sequence.length && sequence(oTmpPos) != "O"){
          oTmpPos += 2
        }
        oNext = if(oTmpPos >= sequence.length) -1 else sequence(oTmpPos + 1).toInt

        var bTmpPos = currentSequence * 2
        while(bTmpPos < sequence.length && sequence(bTmpPos) != "B"){
          bTmpPos += 2
        }
        bNext = if(bTmpPos >= sequence.length) -1 else sequence(bTmpPos + 1).toInt

        // time to move & press
        val a = sequence(currentSequence * 2)
        if(a == "O") {
          val gap = (oNext - oPos).abs + 1
          time += gap
          oPos = oNext
          bPos = if(gap > (bNext - bPos).abs) bNext else bPos + gap
        }
        else if(a == "B") {
          val gap = (bNext - bPos).abs + 1
          time += gap
          bPos = bNext
          oPos = if(gap > (oNext - oPos).abs) oNext else oPos + gap
        }
        currentSequence += 1
      }
      println("Case #%d: %d".format(t, time))
    }
  }
}
