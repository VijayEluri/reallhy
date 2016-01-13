package jillian

import java.io.{PrintStream, FileInputStream, PrintWriter}
import java.util.Scanner

import scala.io.Source

/**
 * Created by SDS on 2015-07-13.
 */
object Problem1 extends App {


  def calculate(day: Int, month: Int, week: Int): Unit = {
    var answer = 1
    val calendar = month/week;
    val remainder = month%week;
    var firstPage, secondPage = 0;

    if (remainder == 0) {
      secondPage = week - 1
    } else {
      secondPage = remainder - 1
    }
    answer = calendar

    if (remainder != 0 ) {
      answer += answer
    }
    while (day != firstPage) {
      firstPage += firstPage
      secondPage += secondPage
      if (secondPage == week) {
        answer += answer
        secondPage = 0;
      }
    }
    //printout answer...

  }

  def run(args: Array[Int]): Int = {

    calculate(args(0), args(1), args(2))

    return 0;
//    val input = Source.fromFile("D:\\SW\\scala\\A-small-practice.in")
//    println(input)
//
//
//    println("Case #" + ":" )
  }

}
