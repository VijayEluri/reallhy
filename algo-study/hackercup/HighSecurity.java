import java.io.*;
import java.util.*;

public class HighSecurity{
	public static void main(String... args){		
		InputStream is = HighSecurity.class.getResourceAsStream("high_security_example_input.txt");
		Scanner scanner = new Scanner(is);
		int t = scanner.nextInt();
		for(int i = 0; i < t; i++){
			int n = scanner.nextInt();
			String[] line1 = new String[n];
			String[] line2 = new String[n];
			for(int j = 0; j < n; j++){
				line1[j] = scanner.next();
			}
			for(int j = 0; j < n; j++){
				line2[j] = scanner.next();
			}
			


			int count = 0;
			System.out.printf("Case #%d: %d\n", i + 1, count);
		}
	}
}