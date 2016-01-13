import java.io.*;
import java.util.*;

/*
* 행렬 경로 문제
* n * n 행렬이 주어지고, 행렬의 좌상단에서 시작하여 우하단까지 이동한다.
* 이동방법(제약조건)
* 오른쪽이나 아래쪽으로만 이동할 수 있다.
* 왼쪽, 위쪽, 대각선 이동은 허용하지 않는다.
* 목표: 행렬의 좌상단에서 시작하여 우하단까지 이동하되, 방문한 칸에 있는 수들을 더한 값이 최소화되도록 한다.
*/
public class MatrixPath{
	public static void main(String... args){		
		InputStream is = Pebble.class.getResourceAsStream("matrix_path_input.txt");
		Scanner scanner = new Scanner(is);
		int T = scanner.nextInt();
		for(int t = 0; t < T; t++){
			int n = scanner.nextInt();
			int[][] matrix = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					matrix[i][j] = scanner.nextInt();
			for(int[] row: matrix) System.out.println(Arrays.toString(row));

			MatrixPath mp = new MatrixPath(matrix);
			int res = mp.shortestPath();
			System.out.printf("Case#%d: %d\n", t + 1, res);
		}
	}

	int[][] matrix;
	MatrixPath(int[][] matrix){
		this.matrix = matrix;
	}

	// O(n2)
	int shortestPath(){
		int n = matrix.length;
		int[][] res = new int[n][n];
		res[0][0] = matrix[0][0];
		for(int i = 1; i < n; i++){
			res[i][0] = res[i - 1][0] + matrix[i][0];
		}		
		for(int j = 1; j < n; j++){
			res[0][j] = res[0][j - 1] + matrix[0][j];
		}
		for(int i = 1; i < n; i++){
			for(int j = 1; j < n; j++){				
				res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + matrix[i][j];
			}
		}

		System.out.println();
		for(int[] row: res) System.out.println(Arrays.toString(row));

		// 최소길이경로로 지나온 지점 추적
		int i = n - 1;
		int j = n - 1;		
		Stack<Tuple> path = new Stack<>();
		path.push(new Tuple(i, j));
		while(true){
			int upper = res[i - 1][j];
			int left = res[i][j - 1];
			if(upper < left){
				i--;
			} else {
				j--;
			}
			path.push(new Tuple(i, j));
			if(i == 0){
				while(j > 0){
					path.push(new Tuple(i, --j));
				}
				break;
			}
			if(j == 0) {
				while(i > 0){	
					path.push(new Tuple(--i, j));
				}
				break;
			}
		}
		while(!path.isEmpty()){
			Tuple tuple = path.pop();
			System.out.printf("(%d, %d) - %d\n", tuple.x, tuple.y, matrix[tuple.x][tuple.y]);
		}
		return res[n - 1][n - 1];
	}
	class Tuple{
		int x;
		int y;
		Tuple(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
