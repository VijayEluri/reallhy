import java.io.*;
import java.util.*;
public class Factorial{
	public static void main(String... args){
		// InputStream is = System.in;
		InputStream is = new ByteArrayInputStream("13".getBytes());		
		Scanner scanner = new Scanner(is);
		long n = scanner.nextLong();
		System.out.println(fact(n));
	}
	static long fact(long n){		
		if(n == 1L) {
			System.out.printf("%d! = %d\n", n, n);	
			return 1L;		
		}
		System.out.printf("%d! = %d * %d!\n", n, n, n-1);
		return n * fact(n - 1);
	}
}