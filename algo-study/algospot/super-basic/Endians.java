import java.io.*;
import java.util.*;
public class Endians{
	public static void main(String... args){
		// InputStream is = System.in;
		InputStream is = new ByteArrayInputStream("4\n2018915346\n1\n100000\n4294967295".getBytes());
		Scanner scanner = new Scanner(is);
		int c = scanner.nextInt();
		for(int i = 0; i < c; i++){			
			long n = scanner.nextLong();
			// little endian to big endian
			// mod 16 byte count ++
			// 32bit.. (1byte = 8bit(256)) * 4
			int cnt = 4;
			long tmp = 0L;
			while(cnt-- > 0) {
				tmp = tmp * 256 + (n % 256);
				n = n / 256;
			}
			System.out.println(tmp);
		}
	}
}