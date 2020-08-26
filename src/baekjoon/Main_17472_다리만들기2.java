package baekjoon;

import java.io.*;
import java.util.*;

public class Main_17472_다리만들기2 {
	
	static int n, m;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[] parents;
	
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
					divIsland(i, j, cnt++);
				}
			}
		}
		parents = new int[cnt];
		for (int i = 1; i < cnt; i++) {
			makeSet(i);
		}
		System.out.println(bridge());
		
	}
	private static void makeSet(int i) {
		parents[i] = i;
	}
	private static int findSet(int i) {
		if(parents[i] == i)
			return i;
		return findSet(parents[i]);
	}
	private static void union(int i, int j) {
		int pi = findSet(i);
		int pj = findSet(j);
		parents[pj] = pi;
	}
	private static int bridge() {
		int result = 0;
		// 그래프 식으로 각 edge 저장
		PriorityQueue<Edge> edge = new PriorityQueue<>();
		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			int from = 0;
			for (int j = 1; j <= m; j++) {
				if(map[i][j] != 0) {
					if(from != 0 && from != map[i][j] && cnt >= 2) {
						int to = Math.max(from, map[i][j]);
						from = Math.min(from, map[i][j]);
						edge.add(new Edge(from, to, cnt));
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
					if(from != 0 && from != map[j][i] && cnt >= 2) {
						int to = Math.max(from, map[j][i]);
						from = Math.min(from, map[j][i]);
						edge.add(new Edge(from, to, cnt));
					}
					from = map[j][i];
					cnt = 0;
				} else {
					cnt++;
				}
			}
		}
		int cnt = 0;
		while(!edge.isEmpty()) {
			Edge cur = edge.poll();
			if(findSet(cur.from) == findSet(cur.to)) continue;
			union(cur.from, cur.to);
			result += cur.cost;
			if(++cnt == parents.length-2) break;
		}
		return cnt == parents.length-2 ? result:-1;
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
