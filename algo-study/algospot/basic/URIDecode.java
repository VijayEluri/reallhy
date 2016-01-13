import java.io.*;
import java.util.*;
public class URIDecode{
	public static void main(String... args){
		// InputStream is = System.in;
		InputStream is = new ByteArrayInputStream("2\nHappy%20Joy%20Joy%21\nhttp://algospot.com/%2d".getBytes());		
		Scanner scanner = new Scanner(is);
		int n = scanner.nextInt();
		for(int i = 0; i < n; i++){
			System.out.println(scanner.next().replace("%20"," ")
				.replace("%21","!").replace("%24","$").replace("%2a","*")
				.replace("%28","(").replace("%29",")").replace("%25","%"));
		}
	}
}