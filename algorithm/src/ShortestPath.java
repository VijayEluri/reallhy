public class ShortestPath{
	public static void main(String... args){
		int[][] map = {{1,1,1,1,1,1}, {0,0,1,0,0,1}, {1,1,1,0,1,1},{1,0,0,0,1,0}, {1,1,1,0,1,0},{0,0,1,1,1,1}};
		ShortestPath sp = new ShortestPath(map);	
		sp.bfs(1,2);
	}
	ShortestPath(int[][] map){
		this.map = map;
		this.n = map.length;
	}
	int[] x = new int[100];
	int[] y = new int[100];
	int[] l = new int[100];
	int cnt = 0;
	int n;
	int[][] map;

	void bfs(int _x, int _y){		
		int pos = 0;		
		enqueue(_x, _y, 1); // starting pos
		while(pos < cnt && (x[pos] != n - 1 || y[pos] != n - 1)){
			map[y[pos]][x[pos]] = 0; // coord in queue
			
			// could go right
			if(x[pos] < n - 1 && map[y[pos]][x[pos] + 1] == 1)
				enqueue(x[pos] + 1, y[pos], l[pos] + 1);			
			// could go down
			if(y[pos] < n -1 && map[y[pos] + 1][x[pos]] == 1)
				enqueue(x[pos], y[pos] + 1, l[pos] + 1);			
			// could go left
			if(x[pos] > 0 && map[y[pos]][x[pos] - 1] == 1)
				enqueue(x[pos] - 1, y[pos], l[pos] + 1);
			// could go up
			if(y[pos] > 0 && map[y[pos] - 1][x[pos]] == 1)
				enqueue(x[pos], y[pos] - 1, l[pos] + 1);

			pos++;
			System.out.printf("y: %d, x: %d, l : %d\n", y[pos], x[pos], l[pos]);
			System.out.printf("pos: %d, cnt: %d\n\n", pos, cnt);
		}
		if(pos < cnt) System.out.printf("%d", l[pos]);
	}
	
	void enqueue(int _x, int _y, int _l){
		x[cnt] = _x;
		y[cnt] = _y;
		l[cnt] = _l;
		cnt++;
	}
}