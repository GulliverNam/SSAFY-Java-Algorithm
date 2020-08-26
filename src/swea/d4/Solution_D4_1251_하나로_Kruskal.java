package swea.d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로_Kruskal {
	
	static int parents[];
	static int xy[][];
	static PriorityQueue<Island> queue;
	
	static class Island implements Comparable<Island>{
		int i,j;
		double cost;
		public Island(int i, int j, double cost) {
			this.i = i;
			this.j = j;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Island o) {
			return Double.compare(this.cost, o.cost);
		}

	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine().trim());
			parents = new int[n];
			xy = new int[n][2];
			for (int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int i = 0; i < n; i++) {
					xy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			double tax = Double.parseDouble(br.readLine().trim());
			
			queue = new PriorityQueue<Island>();
			for (int i = 0; i < n-1; i++) {
				for (int j = i+1; j < n; j++) {
					queue.offer(new Island(i, j, tax*distance(i,j)));
				}
			}
			for (int i = 0; i < n; i++) {
				makeSet(i);
			}
			int cnt = 0;
			double answer = 0;
			while(!queue.isEmpty()) {
				Island cur = queue.poll();
				if(findSet(cur.i) == findSet(cur.j)) continue;
				union(cur.i, cur.j);
				answer += cur.cost;
				cnt++;
				if(cnt == n-1) break;
			}
			bw.write(String.format("#%d %.0f\n", tc, answer));
			
		}
		bw.flush();
		bw.close();
	}
	
	private static void makeSet(int x) {
		parents[x] = x;
	}
	
	private static int findSet(int x) {
		if(parents[x] == x) return x;
		return findSet(parents[x]);
	}
	
	private static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		parents[py] = px;
	}
	
	private static double distance(int from, int to) {
		return Math.pow(xy[from][0]-xy[to][0], 2) + Math.pow(xy[from][1] - xy[to][1], 2);
	}
}
