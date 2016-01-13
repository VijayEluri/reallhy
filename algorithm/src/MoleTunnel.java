import java.util.*;
public class MoleTunnel{
	public static void main(String... args){
		int[][] matrix = new int[5][6];
		matrix[0] = new int[]{0,1,0,1,0,1};
		matrix[1] = new int[]{1,1,0,1,1,1};
		matrix[2] = new int[]{1,1,0,0,1,1};
		matrix[3] = new int[]{0,0,1,1,0,0};
		matrix[4] = new int[]{1,1,1,1,0,0};
		MoleTunnel mt = new MoleTunnel(matrix);
		List<Integer> res = new LinkedList<Integer>();
		for(int i = 0; i < matrix.length ; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(matrix[i][j] == 1){
					res.add(mt.bfs(i, j));
				}
			}
		}
		System.out.println(res);
	}

	int[][] matrix;
	MoleTunnel(int[][] matrix){
		this.matrix = matrix;
	}
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, 1, 0, -1};
	int bfs(int x, int y){
		Queue<Vertex> queue = new LinkedList<Vertex>();
		matrix[x][y] = -1;
		queue.offer(new Vertex(x, y));
		int p = 0;
		while(!queue.isEmpty()){
			Vertex v = queue.poll();
			p++;
			for(int i = 0; i < 4; i++){
				int nextX = v.x + dx[i];
				int nextY = v.y + dy[i];
				if(safe(nextX, nextY) && matrix[nextX][nextY] == 1){
					matrix[nextX][nextY] = -1;
					queue.offer(new Vertex(nextX, nextY));
				}
			}
		}
		return p;
	}

	boolean safe(int x, int y){
		int height = matrix.length;
		int width = matrix[0].length;
		return (x >= 0 && x < height && y >= 0 && y < width);
	}

	static class Vertex{
		int x;
		int y;
		private Vertex(int x, int y){
			this.x = x;
			this.y = y;			
		}
	}
}