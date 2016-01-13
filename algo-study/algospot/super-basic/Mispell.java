import java.io.*;
import java.util.*;
public class Mispell{
	public static void main(String... args){
		// InputStream is = System.in;
		InputStream is = new ByteArrayInputStream("4\n4 MISSPELL\n1 PROGRAMMING\n7 CONTEST\n3 BALLOON".getBytes());
		Scanner scanner = new Scanner(is);
		int n = scanner.nextInt();
		for(int i = 0; i < n; i++){
			int index = scanner.nextInt() - 1;
			String str = scanner.next();
			String res = str.substring(0, index) + str.substring(index + 1);
			System.out.printf("%d %s\n", i + 1, res);
		}
	}
}