package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2468_안전영역_DFS {
	static int N, map[][], dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean visit[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N+2][N+2];
		visit = new boolean[N+2][N+2];
		
		int maxHeight = 0;
		int minHeight = 101;
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, map[i][j]);
				minHeight = Math.min(minHeight, map[i][j]);
			}
		}
		int cnt;
		for(int limit = minHeight - 1; limit < maxHeight; limit++) {
			cnt = 0;
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					if(!visit[r][c] && map[r][c] > limit) {
						dfs(r, c, limit);
						cnt++;
					}
				}
			}
			for (int i = 1; i <= N; i++) {
				Arrays.fill(visit[i], false);
			}
			answer = Math.max(answer, cnt);
		}
		System.out.println(answer);
	}
	
	private static void dfs(int r, int c, int limit) {
		visit[r][c] = true;
		int nr, nc;
		for (int d = 0; d < 4; d++) {
			nr = r + dir[d][0];
			nc = c + dir[d][1];
			if(!visit[nr][nc] && map[nr][nc] > limit) {
				dfs(nr, nc, limit);
			}
		}
	}

}
