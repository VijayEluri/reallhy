public class MinimumSum{
	public static void main(String... args){
		int n = 4;
		int[][] mat = new int[n][n];
		mat[0] = new int[]{1, 5, 3, 0};
		mat[1] = new int[]{2, 4, 7, 2};
		mat[2] = new int[]{5, 3, 5, 1};
		mat[3] = new int[]{5, 3, 5, 6};
		MinimumSum ms = new MinimumSum(mat);
		ms.track(0, 0);
		System.out.println(ms.min);
	}

	int n;
	int[][] mat;
	int[] visited;
	MinimumSum(int[][] mat){
		this.mat = mat;
		this.n = mat.length;
		this.visited = new int[n];
	}
	int min = Integer.MAX_VALUE;
	void track(int row, int sum){
		if(row == n) {
			if(sum < min) min = sum;
			return;
		}
		for(int i = 0 ; i < n ; i++){
			if(visited[i] != 0) continue;
			visited[i] = 1;			
			track(row + 1, visited, sum + mat[row][i]);
			visited[i] = 0;
		}
	}
}