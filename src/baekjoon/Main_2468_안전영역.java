package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2468_안전영역 {
	
	static int n;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine().trim());
		map = new int[n+2][n+2];
		int max = 0;
		int min = 101;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}
		int answer = 1;
		for (int i = min; i < max; i++) {
			boolean[][] visited = new boolean[n+1][n+1];
			int cnt = 0;
			for (int r = 1; r <= n; r++) {
				for (int c = 1; c <= n; c++) {
					if(map[r][c] > i && !visited[r][c]) {
						dfs(r, c, i, visited);
						cnt++;
					}
				}
			}
			answer = Math.max(answer, cnt);
		}
		System.out.println(answer);
		
	}

	private static void dfs(int r, int c, int num, boolean[][] visited) {
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(map[nr][nc] > num && !visited[nr][nc]) {
				dfs(nr, nc, num, visited);
			}
		}
	}

}
