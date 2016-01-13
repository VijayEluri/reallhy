package jungho

/**
 * Created by SDS on 2015-07-13.
 */
import java.util.Scanner

object jh20150710 {
  def main(args: Array[String]) {
    val scan = new Scanner(System.in);
    val testCase = scan.nextLine().toInt;
    val month = new Array[Int](testCase);
    val dayPerMonth = new Array[Int](testCase);
    val dayPerWeek = new Array[Int](testCase);
    val result = new Array[Int](testCase);

    for( i <- 0 until testCase){
      val start = 0;
      var end = 0;
      month(i) = scan.next().toInt;
      dayPerMonth(i) = scan.next().toInt;
      dayPerWeek(i) = scan.next().toInt;

      for( j <- 1 to month(i)){
        result(i) += (end + dayPerMonth(i)) / dayPerWeek(i);
        end = (end + dayPerMonth(i)) % dayPerWeek(i);
        if(start % dayPerWeek(i) != 0) result(i) -= 1;
        if(end % dayPerWeek(i) != 0) result(i) += 1;
      }
    }

    (0 until result.length).foreach(i => println("Case #" + i + ": " + result(i)))
  }
}
