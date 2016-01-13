import java.io.*;
import java.util.*;

public class CorrectPrice{
	public static void main(String... args){		
		InputStream is = CorrectPrice.class.getResourceAsStream("the_price_is_correct_example_input.txt");
		Scanner scanner = new Scanner(is);
		int t = scanner.nextInt();
		for(int i = 0; i < t; i++){
			int n = scanner.nextInt();


			int count = 0;
			System.out.printf("Case #%d: %d\n", i + 1, count);
		}
	}
}