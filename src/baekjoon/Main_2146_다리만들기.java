package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2146_다리만들기 {

	static int n;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] map, border;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine().trim());
		map = new int[n+2][n+2];
		border = new int[n+2][n+2];
		Arrays.fill(map[0], -2);
		Arrays.fill(map[n+1], -2);
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			Arrays.fill(map[i], -2);
			for (int j = 1; j <= n; j++) {
				map[i][j] = -Integer.parseInt(st.nextToken());
			}
		}
		
		int num = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(map[i][j] == -1) {
					divIsland(i, j, ++num);
				}
			}
		}
		int answer = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(border[i][j] != 0) {
					boolean[][] visited = new boolean[n+2][n+2];
					int from = border[i][j];
					Queue<int[]> queue = new ArrayDeque<int[]>();
					queue.add(new int[] {i,j,1});
					visited[i][j] = true;
					int cnt = 0;
					top:
					while(!queue.isEmpty()) {
						int[] cur = queue.poll();
						for (int d = 0; d < 4; d++) {
							int r = cur[0] + dr[d];
							int c = cur[1] + dc[d];
							if(map[r][c] > 0 && map[r][c] != from) {
								cnt = cur[2];
								break top;
							}
							if(!visited[r][c] && map[r][c] == 0 && cur[2] + 1 < answer) {
								visited[r][c] = true;
								queue.add(new int[] {r, c, cur[2]+1});
							} 
						}
					}
					if(cnt != 0)
						answer = Math.min(answer, cnt);
				}
			}
		}
		System.out.println(answer);
	}

	private static void divIsland(int r, int c, int num) {
		map[r][c] = num;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(map[nr][nc] == 0) {
				border[nr][nc] = num;
			} else if(map[nr][nc] == -1) {
				divIsland(nr, nc, num);
			}
		}
	}

}
