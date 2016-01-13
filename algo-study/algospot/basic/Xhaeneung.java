import java.io.*;
import java.util.*;
public class Xhaeneung{
	public static void main(String... args){
		// InputStream is = System.in;
		InputStream is = new ByteArrayInputStream("2\nHappy%20Joy%20Joy%21\nhttp://algospot.com/%2d".getBytes());		
		Scanner scanner = new Scanner(is);
		int n = scanner.nextInt();
		for(int i = 0; i < n; i++){
			//TODO do your job.
		}
	}
}