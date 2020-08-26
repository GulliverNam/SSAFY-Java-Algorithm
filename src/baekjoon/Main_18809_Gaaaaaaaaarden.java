package baekjoon;

import java.io.*;
import java.util.*;

public class Main_18809_Gaaaaaaaaarden {

	static int n, m, g, r, answer;
	static int[][] map;
	static List<int[]> ground;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n+2][m+2];
		ground = new ArrayList<int[]>();
		Arrays.fill(map[0], -1);
		Arrays.fill(map[n+1], -1);
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			Arrays.fill(map[i], -1);
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					ground.add(new int[] {i,j});
				}
			}
		}
		answer = 0;
		char[] selected = new char[ground.size()];
		Arrays.fill(selected, ' ');
		pickRed(0,0,selected);
		System.out.println(answer);

	}

	private static void pickRed(int start, int cnt, char[] selected) {
		if(cnt == r) {
			pickGreen(0,0,selected);
			return;
		}
		for (int i = start, size = ground.size(); i < size; i++) {
			if(selected[i] == ' ') {
				selected[i] = 'r';
				pickRed(i+1, cnt+1, selected);
				selected[i] = ' ';
			}
		}
		
	}

	private static void pickGreen(int start, int cnt, char[] selected) {
		if(cnt == g) {
			bfs(selected);
			return;
		}
		for (int i = start, size = ground.size(); i < size; i++) {
			if(selected[i] == ' ') {
				selected[i] = 'g';
				pickGreen(i+1, cnt+1, selected);
				selected[i] = ' ';
			}
		}
		
	}

	private static void bfs(char[] selected) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		int[][][] visited = new int[n+2][m+2][2];
		for (int i = 0, size = ground.size(); i < size; i++) {
			int[] g = ground.get(i);
			if(selected[i] == 'r') {
				queue.add(new int [] {g[0], g[1], 0, 1});
				visited[g[0]][g[1]][0] = 1;
			} else if (selected[i] == 'g') {
				queue.add(new int [] {g[0], g[1], 1, 1});
				visited[g[0]][g[1]][1] = 1;
			}
		}
		int flower = 0;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int other = cur[2] ^ 1;
			if(visited[cur[0]][cur[1]][other] == cur[3]) {
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if(map[nr][nc] > 0 && visited[nr][nc][cur[2]] == 0) {
					if(visited[nr][nc][other] == cur[3] + 1) {
						visited[nr][nc][cur[2]] = cur[3] + 1;
						flower++;
					} else if(visited[nr][nc][other] == 0) {
						visited[nr][nc][cur[2]] = cur[3] + 1;
						queue.add(new int[] {nr, nc, cur[2], cur[3]+1});
					}
				}
			}
		}
		if(answer < flower)
			answer = flower;
	}

}
