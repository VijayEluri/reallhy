import java.io.*;
import java.util.*;
public class HanoiTower{
	public static void main(String... args){
		// InputStream is = System.in;
		InputStream is = new ByteArrayInputStream("3".getBytes());		
		Scanner scanner = new Scanner(is);
		int n = scanner.nextInt();		
		move(n);
	}
	static void move(int n){
		
	}

}