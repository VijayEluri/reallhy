import java.io.*;
import java.util.*;
public class Dice2{
	public static void main(String... args){
		// InputStream is = System.in;
		InputStream is = new ByteArrayInputStream("7 40".getBytes());		
		Scanner scanner = new Scanner(is);
		int n = scanner.nextInt();
		int m = scanner.nextInt();		
		roll(n, new int[n], 0, m);
	}

	static int[] dice = {1,2,3,4,5,6};
	static void roll(int n, int[] buf, int index, int m){		
		for(int i : dice){
			if(n == index) {
				Line line = new Line(buf);
				if(m == line.sum()){
					System.out.printf("%s\n", line.toString());
				}
				return;
			}
			buf[index] = i;
			roll(n, buf, index + 1, m);
		}
	}
	static class Line{
		int[] buf;
		Line(int[] buf){
			this.buf = buf;
		}
		public int sum(){
			int res = 0;
			for(int i: buf){
				res += i;
			}
			return res;
		}

		public String toString(){
			String str = "";
			for(int i : buf){
				str += (i + " ");
			}
			return str;
		}
	}
}