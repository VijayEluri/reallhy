import java.io.*;
import java.util.*;
public class Calendar{
	public static void main(String... args){
		Calendar calendar = new Calendar();
		InputStream is = new ByteArrayInputStream("2001 13 29\n2010 12 31".getBytes());
		Scanner sc = new Scanner(is);
		while(sc.hasNext()){
			String[] split = sc.nextLine().split(" ");
			if(split.length != 3) System.out.println("INPUT ERROR!");
			int y = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);
			int d = Integer.parseInt(split[2]);
			if(calendar.invalidDate(y, m, d)) {
				System.out.println("INPUT ERROR!");
			} else {
				calendar.draw(y, m, d);
				break;
			}
		}		
	}

	boolean invalidDate(int y, int m, int d){
		if(y >= 2000 && y <= 2020){
			if(m >= 1 && m <= 12 && d >= 1 && d <= daysInMonth[m - 1]) return false;
			
			if(m == 2 && lunarYear(y)){
				if(d >= 1 && d <= 29) return false;			
			}
		}
		return true;
	}

	boolean lunarYear(int y){
		return y % 400 == 0 || (y % 4 == 0 && y % 100 != 0);
	}

	// 0 -> 1월, 1 -> 2월...
	int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	int daysInYear = 365;
	String[] weekdays = {"sun", "mon", "tue", "wed", "thu", "fri", "sat"};
	String[] fqnWeekdays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	void draw(int y, int m, int d){
		System.out.printf("%d. %d\n", y, m);
		for(String weekday : weekdays)
			System.out.printf("%s ", weekday);
		System.out.println();
		// base 2000 1 1 sat
		// calculate days from 2000 1 1 to y m 1		
		int dd = daysBetweenYears(2000, y) + daysToDay1ThisMonthInThisYear(y, m);
		
		// calculate weekday from 2000 1 1 saturday
		int weekdayIndex = (6 + dd) % 7;		
		int lastday = daysInMonth[m - 1];
		if(lunarYear(y) && m == 2) lastday = 29;

		for(int i = 0; i < weekdayIndex; i++){
			System.out.printf("%4s", "");
		}

		int theWeekDayIndex = 0;
		for(int day = 1; day <= lastday; day++){
			System.out.printf("%3d ", day);
			if(d == day) theWeekDayIndex = weekdayIndex % 7;
			if(weekdayIndex++ % 7 == 6) System.out.println();			
		}
		if(weekdayIndex % 7 != 0) System.out.println();
		System.out.println(fqnWeekdays[theWeekDayIndex]);
	}

	int daysBetweenYears(int thisYear, int y){
		int days = 0;
		while(thisYear < y){
			if(lunarYear(thisYear)) days += 1;
			days += daysInYear;
			thisYear++;
		}
		return days;
	}
	
	int daysToDay1ThisMonthInThisYear(int y, int m){
		int days = 0;
		int thisMonth = 1;
		while(thisMonth < m){
			if(thisMonth == 2 && lunarYear(y)) days += 1;
			days += daysInMonth[thisMonth - 1];
			thisMonth++;
		}
		return days;
	}
}