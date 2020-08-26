package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_16234_인구이동 {

	static int N, L, R, map[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int sum, cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N+2][N+2];
		Arrays.fill(map[0], -1);
		Arrays.fill(map[N+1], -1);
		for (int i = 1; i <= N; i++) {
			Arrays.fill(map[i], -1);
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int border = 0;
		int answer = 0;
		while(true) {
			int[][] visited = new int[N+1][N+1];
			int[] population = new int[N*N+1];
			border = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(visited[i][j] == 0) {
						sum = 0;
						cnt = 0;
						dfs(i, j, ++border, visited);
						population[border] = sum/cnt;
					}
				}
			}
			if(border == N*N) break;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(visited[i][j] != 0) {
						map[i][j] = population[visited[i][j]];
					}
				}
			}
			answer++;
		}
		System.out.println(answer);
	}

	private static void dfs(int r, int c, int border, int[][] visited) {
		visited[r][c] = border;
		sum += map[r][c];
		cnt++;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			int diff = Math.abs(map[r][c] - map[nr][nc]);
			if(map[nr][nc] != -1 && visited[nr][nc] == 0 && L <= diff && diff <= R){
				dfs(nr, nc, border, visited);
			}
		}
		
	}

}
