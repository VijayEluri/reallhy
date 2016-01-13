import java.io.*;
import java.util.*;
public class Encrypt{
	public static void main(String... args){
		// InputStream is = System.in;
		InputStream is = new ByteArrayInputStream("4\nA\nDAB\nABCDE\nHelloWorld".getBytes());
		Scanner scanner = new Scanner(is);
		int n = scanner.nextInt();
		for(int i = 0; i < n; i++){
			char[] str = scanner.next().toCharArray();
			char[] buf = new char[str.length];
			for(int j = 0; j < str.length; j += 2){
				buf[j / 2] = str[j];
			}
			for(int j = 1; j < str.length; j += 2){
				buf[j / 2 + (str.length + 1) / 2] = str[j];
			}
			System.out.println(new String(buf));
		}
	}
}