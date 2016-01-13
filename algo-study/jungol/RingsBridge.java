import java.io.*;
import java.util.*;
public class RingsBridge{
	public static void main(String... args){
		// InputStream is = new ByteArrayInputStream("RGS\nRINGSR\nGRGGNS".getBytes());
		InputStream is = new ByteArrayInputStream("RINGS\nSGNIRSGNIR\nGNIRSGNIRS".getBytes());
		Scanner scanner = new Scanner(is);
		char[] keys = scanner.nextLine().toCharArray();
		char[] devil = scanner.nextLine().toCharArray();
		char[] angel = scanner.nextLine().toCharArray();
		RingsBridge obj = new RingsBridge(keys, devil, angel);
		obj.combination(devil.length, keys.length, new int[keys.length], 0, 0);
		System.out.println(obj.cnt);
	}
	
	int cnt = 0;

	char[] keys;
	char[] devil;
	char[] angel;

	RingsBridge(char[] keys, char[] devil, char[] angel){
		this.keys = keys;
		this.devil = devil;
		this.angel = angel;
	}

	// pick r elements to buf from the array of size n
	void combination(int n, int r, int[] buf, int index, int i){
		if(r == index) {
			// System.out.println(Arrays.toString(buf));
			countWays(buf);			
			return;
		}
		if(i >= n) return;

		buf[index] = i;
		combination(n, r, buf, index + 1, i + 1);
		combination(n, r, buf, index, i + 1);
	}

	void countWays(int[] buf){
		char[] devilBuf = new char[keys.length];				
		boolean devMatched = false;
		for(int k = 0; k < keys.length; k++){
			if(k % 2 == 0){
				devilBuf[k] = devil[buf[k]];
			} else{
				devilBuf[k] = angel[buf[k]];
			}
			if(devilBuf[k] != keys[k]) {
				devMatched = false;
				break;
			} else devMatched = true;
		}
		if(devMatched) cnt++;

		boolean angelMatched = false;	
		char[] angelBuf = new char[keys.length];				
		for(int k = 0; k < keys.length; k++){
			if(k % 2 == 0){
				angelBuf[k] = angel[buf[k]];					
			} else{
				angelBuf[k] = devil[buf[k]];					
			}
			if(angelBuf[k] != keys[k]){
				angelMatched = false;
				break;
			} else angelMatched = true;
		}
		if(angelMatched) cnt++;
	}
}