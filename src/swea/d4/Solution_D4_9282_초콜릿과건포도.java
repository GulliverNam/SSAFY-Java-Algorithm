package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_9282_초콜릿과건포도 {
	
	static int n, m, result, map[][], memo[][][][];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/Solution_D4_9282_초콜릿과건포도.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			memo = new int[n+1][m+1][n+1][m+1];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result = dfs(0, 0, n, m, Integer.MAX_VALUE);
			System.out.println("#"+tc+" "+result);
		}
	}

	private static int dfs(int r, int c, int h, int w, int min) {
		if(memo[r][c][h][w] != 0)
			return memo[r][c][h][w];
		if(w == 1 && h == 1)
			return 0;
		int sum = 0;
		for (int i = r; i < r+h; i++) {
			for (int j = c; j < c+w; j++) {
				sum += map[i][j];
			}
		}
		for (int i = 1; i < h; i++) {
			min = Math.min(min, sum+dfs(r,c,i,w,min)+dfs(r+i,c,h-i,w,min));
		}
		for (int i = 1; i < w; i++) {
			min = Math.min(min, sum+dfs(r,c,h,i,min)+dfs(r,c+i,h,w-i,min));
		}
		memo[r][c][h][w] = min;
		return min;
	}

}
