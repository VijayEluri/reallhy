import java.io.*;
import java.util.*;
public class Lecture{
	public static void main(String... args){
		// InputStream is = System.in;
		InputStream is = new ByteArrayInputStream("4\nabbaaccb\ndddcccbbbaaa\ngeegeegeegeebabybabybaby\noh".getBytes());		
		Scanner scanner = new Scanner(is);
		int n = scanner.nextInt();
		for(int i = 0; i < n; i++){
			char[] str = scanner.next().toCharArray();
			String[] buf = new String[str.length / 2];
			for(int j = 0; j < str.length; j += 2 ){
				buf[j / 2] = "" + str[j] + str[j + 1];
			}
			Arrays.sort(buf);
			for(String s : buf)
				System.out.printf("%s", s);
			System.out.println();
		}
	}
}