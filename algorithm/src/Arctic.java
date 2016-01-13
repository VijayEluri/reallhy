import java.util.*;
import java.io.*;
public class Arctic{

	public static void  main(String... args){
		System.setIn(new ByteArrayInputStream("2\n5\n0 0\n1 0\n1 1\n1 2\n0 2\n6\n1.0 1.0\n30.91 8\n4.0 7.64\n21.12 6.0\n11.39 3.0\n5.31 11.0".getBytes()));
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for(int i = 0; i < t; i++){			
			int n = scanner.nextInt();
			Coord[] towers = new Coord[n];
			for(int j = 0; j < n; j++){
				towers[j] = new Coord(scanner.nextDouble(), scanner.nextDouble());
			}
			Arctic arctic = new Arctic(towers);
			arctic.minPower(0, new boolean[n], new double[n - 1]);
			System.out.printf("%.2f\n",arctic.min);
		}
	}
	int n;
	Coord[] towers;
	Coord head;
	Arctic(Coord[] towers){
		this.towers = towers;
		this.n = towers.length;
		this.head = towers[0];
	}
	double min = Integer.MAX_VALUE;
	
	void minPower(int cur, boolean[] visited, double[] powers){		
		visited[cur] = true;
		for(int i = 0; i < n; i++){
			if(visited[i]) continue;

			visited[i] = true;
			double d = Math.sqrt((towers[cur].x - towers[i].x) * (towers[cur].x - towers[i].x) + (towers[cur].y - towers[i].y) * (towers[cur].y - towers[i].y));				
			powers[cur] = d;
			if(cur == n - 2){
				System.out.println(Arrays.toString(powers));
				// if(min > max(powers)) min = max(powers);
				return;
			}
			minPower(cur + 1, visited, powers);
			powers[cur] = 0;
			visited[i] = false;			
		}
		System.out.println("XXXXX "+Arrays.toString(powers));
		
	}
	private static class Coord {
		double x;
		double y;
		Coord(double x, double y){
			this.x = x;
			this.y = y;
		}
	}
}