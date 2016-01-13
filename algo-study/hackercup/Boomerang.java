import java.io.*;
import java.util.*;
public class Boomerang{
	public static void main(String... args){
		InputStream is = Boomerang.class.getResourceAsStream("boomerang_constellations.txt");
		Scanner scanner = new Scanner(is);
		int t = scanner.nextInt();
		for(int i = 0; i < t; i++){
			int n = scanner.nextInt();
			Star[] plain = new Star[n];
			for(int j = 0; j < n; j++){
				plain[j] = new Star(scanner.nextInt(), scanner.nextInt());
			}
			// 1st distance.. and then compare all other stars
			// use hashset.. if exists, then count +1
			// should coincide one star
			
			int count = 0;
			for(int k = 0; k < n; k++){
				Map<Long, Integer> map = new HashMap<>();
				for(int l = 0; l < n; l++){
					if(k == l) continue;
					long length = distance(plain[k], plain[l]);
					if(!map.containsKey(length)){
						map.put(length, 0);
					}
					map.put(length, map.get(length) + 1);	
				}
				for(long length : map.keySet()){
					int c = map.get(length);
					count += (c * (c - 1) / 2);
				}
			}
			System.out.printf("Case #%d: %d\n", i + 1, count);
		}
	}

	static long distance(Star s1, Star s2){
		return (s1.x - s2.x) * (s1.x - s2.x) + (s1.y - s2.y) * (s1.y - s2.y);
	}

	static class Star{
		int x;
		int y;
		Star(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}