import java.io.*;
import java.util.*;
public class Dice{
	public static void main(String... args){
		// InputStream is = System.in;
		InputStream is = new ByteArrayInputStream("10 2".getBytes());		
		Scanner scanner = new Scanner(is);
		int n = scanner.nextInt();
		int m = scanner.nextInt();		
		roll(n, new int[n], 0, m);
	}

	static int[] dice = {1,2,3,4,5,6};
	static Set<Line> set = new HashSet<Line>();
	static void roll(int n, int[] buf, int index, int m){		
		for(int i : dice){
			if(n == index) {
				Line line = new Line(buf);
				if(m == 1){
					System.out.printf("%s\n", line.toString());
				}
				else if(m == 2){
					if(set.add(line)){
						System.out.printf("%s\n", line.toString());
					}
				}
				else if(m == 3){
					if(line.isAllDifferent()){
						System.out.printf("%s\n", line.toString());
					}
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
		public boolean isAllDifferent(){
			int[] tmp = new int[dice.length];
			for(int i : buf){
				if(tmp[i - 1] != 0) return false;
				tmp[i - 1] = i; 
			}
			return true;
		}

		public int hashCode(){
			int[] sorted = buf.clone();
			Arrays.sort(sorted);
			
			String str = "";
			for(int i : sorted){
				str += (i + " ");
			}
			return str.hashCode();
		}
		public boolean equals(Object that){			
			return this.hashCode() == that.hashCode();
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