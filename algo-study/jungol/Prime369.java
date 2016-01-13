import java.io.*;
import java.util.*;
public class Prime369{
	public static void main(String... args){
		InputStream is = new ByteArrayInputStream("3 9 1".getBytes());
		Scanner scanner = new Scanner(is);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int k = scanner.nextInt();
		int res = new Prime369().numOfClap(n, m, k);
		System.out.println(res);
	}

	int numOfClap(int n, int m, int k){
		buildPrimes();
		int cnt = 0;
		for(int i = 1; i < m; i++){
			if(i % n - 1 == k && primes[i] == 1) cnt++;
		}
		return cnt;
	}

	int[] primes = new int[1000*1000 + 1];
	void buildPrimes(){
		primes[0] = -1;
		primes[1] = -1;
		for(int i = 2; i < primes.length; i++){
			// unmarked : 0, prime : 1, not a prime : -1
			int j = 1;
			while(true){
				int pos = i * j;				
				if(pos >= primes.length) break;	
				if(primes[pos] == 0){
					if(j == 1) primes[pos] = 1;
					else primes[pos] = -1;
				}
				j++;
			}
		}
	}
}