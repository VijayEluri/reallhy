import java.io.*;
import java.util.*;
public class HotSummer{
	public static void main(String... args){
		// InputStream is = System.in;
		InputStream is = new ByteArrayInputStream("3\n90\n10 10 10 10 10 10 10 10 10\n1000\n77 77 70 11 34 35 41 83 54\n50\n10 20 30 40 50 60 50 40 30".getBytes());
		Scanner scanner = new Scanner(is);
		int n = scanner.nextInt();
		for(int i = 0; i < n; i++){
			int target = scanner.nextInt();
			int sum = 0;
			for(int j = 0 ; j < 9; j++){
				sum += scanner.nextInt();
			}
			System.out.println((target >= sum)? "YES" : "NO");
		}
	}
}