package kwangsun

import java.util.Stack
import org.scalatest.Finders
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FeatureSpec
import scala.io.Source
import scala.util.control.Exception._

class CalendarProblemTestSuit extends FeatureSpec with GivenWhenThen with Matchers {
  
	feature(s"월날수가 주날수로 나누어 떨어지는 경우") {
    scenario(s"12, 30, 5 returns ") {
      // 1 2 3 4 5
      // 6 7 8 9 0
      // 1 2 3 4 5
      // 6 7 8 9 0
      // 1 2 3 4 5
      // 6 7 8 9 0
      // ... x 12
      CalendarProblem.solve(12, 30, 5) shouldBe (30/5 * 12)
    }
    scenario(s"11, 30, 5 returns ") {
      // 1 2 3 4 5
      // 6 7 8 9 0
      // 1 2 3 4 5
      // 6 7 8 9 0
      // 1 2 3 4 5
      // 6 7 8 9 0
      // ... x 11
      CalendarProblem.solve(11, 30, 5) shouldBe (30/5 * 11)
    }
  }
  
  feature(s"월날수가 주날수로 나누어 떨어지지 않는 경우, 단 n개월 단위로 일정하게 나뉘는 경우") {
    scenario(s"2, 9, 6 returns 4 , 2개월단위로 나뉘는 경우") {
      // 1 2 3 4 5 6
      // 7 8 9
      //       1 2 3
      // 4 5 6 7 8 9
      CalendarProblem.solve(2, 9, 6) shouldBe 4
    }
    
    scenario(s"3, 8, 6 returns 6 , 3개월단위로 나뉘는 경우") {
      // 1 2 3 4 5 6
      // 7 8 
      //     1 2 3 4
      // 5 6 7 8
    	//         1 2
    	// 3 4 5 6 7 8
      CalendarProblem.solve(3, 8, 6) shouldBe 6
    }
    
    scenario(s"6, 8, 6 returns 6 , 3개월단위로 나뉘는 경우") {
    	// 1 2 3 4 5 6
    	// 7 8 
    	//     1 2 3 4
    	// 5 6 7 8
    	//         1 2
    	// 3 4 5 6 7 8
    	// 1 2 3 4 5 6
    	// 7 8 
    	//     1 2 3 4
    	// 5 6 7 8
    	//         1 2
    	// 3 4 5 6 7 8
    	CalendarProblem.solve(6, 8, 6) shouldBe 12
    }
  }
  
  feature(s"월날수가 주날수로 나누어 떨어지지 않는 경우, 단 일정하게 나뉘지 않는 경우") {
    scenario(s"4, 7, 6 returns 8") {
      // 1 2 3 4 5 6
      // 7
      //   1 2 3 4 5
      // 6 7
      //     1 2 3 4 
    	// 5 6 7
      //       1 2 3
    	// 4 5 6 7
      CalendarProblem.solve(4, 7, 6) shouldBe 8
    }
    
    scenario(s"4, 5, 6 returns 7") {
    	// 1 2 3 4 5 
    	//           1
      // 2 3 4 5 
    	//         1 2 
    	// 3 4 5
    	//       1 2 3
    	// 4 5
    	CalendarProblem.solve(4, 5, 6) shouldBe 7
    }
  }
  
  
  feature(s"주어진 테스트케이스") {
    scenario(s"3, 11, 4 returns 11") {
    	CalendarProblem.solve(3, 11, 4) shouldBe 11
    }
    scenario(s"12, 28, 7 returns 48") {
      CalendarProblem.solve(12, 28, 7) shouldBe 48
    }
    scenario(s"10, 35, 10 returns 40") {
    	CalendarProblem.solve(10, 35, 10) shouldBe 40
    }
  }
  
}