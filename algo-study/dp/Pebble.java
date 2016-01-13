import java.io.*;
import java.util.*;

/*
* 조약돌 놓기
* 3 * N 테이블의 각 칸에 양 또는 음의 정수가 기록되어 있다.
* 조약돌을 놓는 방법
* 각 열에는 적어도 하나의 조약돌을 놓아야 한다.
* 가로나 세로로 인접한 두 칸에 동시에 조약돌을 놓을 수 없다
* 목표 : 돌이 놓인 자리에 있는 수의 합을 최대가 되도록 조약돌 놓기
*/
public class Pebble{
	public static void main(String... args){		
		InputStream is = Pebble.class.getResourceAsStream("pebble_input.txt");
		Scanner scanner = new Scanner(is);
		int T = scanner.nextInt();
		for(int t=0; t < T; t++){
			int n = scanner.nextInt();
			int r = scanner.nextInt();
			int[][] mat = new int[r][n];
			for(int i = 0; i < r; i++){
				int[] row = new int[n]; 
				for(int j = 0; j < n; j++){
					row[j] = scanner.nextInt();
				}
				mat[i] = row;
			}
			for(int[] row : mat) System.out.println(Arrays.toString(row));
			
			Pebble peb = new Pebble(mat);
			int res = peb.pebbleSum_dp(n);
			// int res = peb.pebbleSum(n);
			System.out.printf("Case#%d: %d\n", t + 1, res);
		}
	}
	// Pattern match => p : q
	int[][] match = new int[][]{ {1, 2}, {0, 2, 3}, {0, 1}, {1} };	
	
	int[][] matrix;
	Pebble(int[][] mat){
		this.matrix = mat;
	}

	// ==============================================================
	// 					Dynamic Programming
	// ==============================================================
	// O(n)
	int pebbleSum_dp(int n){
		int[][] peb = new int[n][4];
		for(int p = 0; p < 4; p++){
			peb[0][p] = weight(0, p);
		}
		for(int i = 1; i < n; i++){
			for(int p = 0; p < 4; p++){
				// 다음 패턴별 계산결과는 다음열의 값에 현재 열의 매치되는 패턴에 있는 계산결과 중 가장 큰 값을 더한것
				peb[i][p] = weight(i, p) + max(peb[i - 1], match[p]);
			}
		}
		int res = Integer.MIN_VALUE;
		for(int p = 0; p < 4; p++){
			if(peb[n - 1][p] > res) res = peb[n - 1][p];
		}

		System.out.println();
		for(int[] p : peb) System.out.println(Arrays.toString(p));
		
		return res;
	}

	int max(int[] pebRow, int[] qArr){
		int max = Integer.MIN_VALUE;
		for(int q : qArr){
			int tmp = pebRow[q];
			if(tmp > max) max = tmp;
		}
		return max;
	}

	int weight(int i, int p){
		 return (p == 0)? matrix[0][i] : 
				(p == 1)? matrix[1][i] : 
				(p == 2)? matrix[2][i] : 
				(p == 3)? matrix[0][i] + matrix[2][i]: 0;
	}


	// ==============================================================
	// 						recursive
	// ==============================================================

	// 재귀적 방법 - 계산중복이 많아 효율적이지 않음
	int pebbleSum(int n){
		int pebbleSum = Integer.MIN_VALUE;
		for(int p = 0; p < 4; p++){
			int tmp = pebble(n - 1, p);
			if(tmp > pebbleSum) pebbleSum = tmp;
		}
		return pebbleSum;
	}
	int pebble(int i, int p){
		if(i == 0) return weight(i, p);
		int max = Integer.MIN_VALUE;
		for(int q = 0; q < 4; q++){
			if(matched(p, q)){
				 int tmp = pebble(i - 1, q);
				 if(tmp > max) max = tmp;
			}
		}
		return weight(i, p) + max;
	}

	boolean matched(int p, int q){
		int[] candidates = match[p];
		for(int candidate : candidates){	
			if(candidate == q) return true;
		}
		return false;
	}
}