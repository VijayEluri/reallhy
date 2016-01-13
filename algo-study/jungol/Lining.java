import java.io.*;
import java.util.*;
public class Lining{
	public static void main(String... args){
		// InputStream is = new ByteArrayInputStream("10\n0 1 1 0 0 0 5 2 3 7".getBytes());
		InputStream is = new ByteArrayInputStream("5\n0 1 1 3 2".getBytes());
		// InputStream is = System.in;
		Scanner scanner = new Scanner(is);
		int n = scanner.nextInt();
		int[] pick = new int[n];
		for(int i = 0 ; i < n; i++){
			pick[i] = scanner.nextInt();
		}
		int[] line = new int[n];
		for(int i = n - 1; i >= 0; i--){
			int p = pick[i];			
			int ind = n - 1;
			for(int j = 0; j < p; j++){
				while(line[ind] != 0){
					ind--;	
				}				
				ind--;
			}
			while(line[ind] != 0){
				ind--;	
			}				
			// System.out.printf("%d => %d, ind : %d \n", (i + 1), p, ind);
			line[ind] = i + 1;
		}
		for(int k = 0; k < n; k++)
			System.out.printf("%d ", line[k]);
	}
}