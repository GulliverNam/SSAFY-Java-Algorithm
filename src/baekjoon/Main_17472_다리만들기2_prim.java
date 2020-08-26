package baekjoon;

import java.io.*;
import java.util.*;

public class Main_17472_다리만들기2_prim {
	
	static int n, m;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static class Edge implements Comparable<Edge>{
		int from, to, cost;

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+2][m+2];
		Arrays.fill(map[0], -2);
		Arrays.fill(map[n+1], -2);
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			Arrays.fill(map[i], -2);
			for (int j = 1; j <= m; j++) {
				map[i][j] = -Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if(map[i][j] == -1) {
					// 섬 넘버링
					divIsland(i, j, cnt++);
				}
			}
		}
		System.out.println(bridge(cnt));
		
	}
	private static int bridge(int numIsland) {
		int result = 0;
		// 그래프 식으로 각 edge 저장
		List<Edge>[] edge = new ArrayList[numIsland];
		for (int i = 1; i < numIsland; i++) {
			edge[i] = new ArrayList<>();
		}
		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			int from = 0;
			for (int j = 1; j <= m; j++) {
				if(map[i][j] != 0) {
					if(from != 0 && cnt >= 2) {
						int to = Math.max(from, map[i][j]);
						from = Math.min(from, map[i][j]);
						edge[from].add(new Edge(from, to, cnt));
						edge[to].add(new Edge(to, from, cnt));
					}
					from = map[i][j];
					cnt = 0;
				} else {
					cnt++;
				}
			}
		}
		for (int i = 1; i <= m; i++) {
			int cnt = 0;
			int from = 0;
			for (int j = 1; j <= n; j++) {
				if(map[j][i] != 0) {
					if(from != 0 && cnt >= 2) {
						int to = Math.max(from, map[j][i]);
						from = Math.min(from, map[j][i]);
						edge[from].add(new Edge(from, to, cnt));
						edge[to].add(new Edge(to, from, cnt));
					}
					from = map[j][i];
					cnt = 0;
				} else {
					cnt++;
				}
			}
		}
		int cnt = 0;
		boolean check[] = new boolean[numIsland];
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		queue.addAll(edge[1]);
		check[1] = true;
		while(!queue.isEmpty()) {
			Edge cur = queue.poll();
			if(check[cur.to]) continue;
			check[cur.to] = true;
			result += cur.cost;
			queue.addAll(edge[cur.to]);
			if(++cnt == numIsland-2) break;
		}
		return cnt == numIsland-2 ? result:-1;
	}
	private static void divIsland(int r, int c, int cnt) {
		map[r][c] = cnt;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(map[nr][nc] == -1)
				divIsland(nr, nc, cnt);
		}
	}

}
