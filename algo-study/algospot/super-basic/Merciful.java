import java.io.*;
import java.util.*;
public class Merciful{
	public static void main(String... args){
		// InputStream is = System.in;
		InputStream is = new ByteArrayInputStream("2".getBytes());		
		Scanner scanner = new Scanner(is);
		int n = scanner.nextInt();
		for(int i = 0; i < n; i++){			
			System.out.println("Hello Algospot!");
		}
	}
}