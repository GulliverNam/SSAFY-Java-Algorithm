package baekjoon;

import java.io.*;
import java.util.*;

public class Main_17142_연구소3 {
	
	static int n, m, answer, total;
	static int[][] map;
	static List<int[]> virus;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+2][n+2];
		virus = new ArrayList<>();
		total = 0;
		Arrays.fill(map[0], -1);
		Arrays.fill(map[n+1], -1);
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			Arrays.fill(map[i], -1);
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					virus.add(new int[] {i, j});
					total++;
				} else if(map[i][j] == 0) {
					total++;
				}
			}
		}
		answer = Integer.MAX_VALUE;
		dfs(0, 0, 0);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	private static void dfs(int start, int cnt, int mask) {
		if(cnt == m) {
			bfs(mask);
			return;
		}
		for (int i = start, size = virus.size(); i < size; i++) {
			if((mask & 1 << i) == 0) {
				dfs(i+1, cnt+1, mask | 1 << i);
			}
		}
	}

	private static void bfs(int mask) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		boolean[][] visited = new boolean[n+2][n+2];
		for (int i = 0, size = virus.size(); i < size; i++) {
			if((mask & 1 << i) != 0) {
				int[] v = virus.get(i);
				queue.add(new int[] {v[0], v[1], 0});
				visited[v[0]][v[1]] = true;
			}
		}
		int cnt = m;
		int maxTime = 0;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(map[cur[0]][cur[1]] == 0)
				maxTime = Math.max(maxTime, cur[2]);
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if(!visited[nr][nc]) {
					if(map[nr][nc] == 0 || map[nr][nc] == 2) {
						visited[nr][nc] = true;
						queue.add(new int[] {nr,nc,cur[2]+1});
						cnt++;
					}
				}
			}
		}
		if(total == cnt) {
			answer = Math.min(answer, maxTime);
		}
	}

}
