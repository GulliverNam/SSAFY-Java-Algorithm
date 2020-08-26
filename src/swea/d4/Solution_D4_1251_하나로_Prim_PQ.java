package swea.d4;

import java.io.*;
import java.util.*;

public class Solution_D4_1251_하나로_Prim_PQ {
	
	static int xy[][];
	static double tax;
	static List<Island> adj[];
	static class Island implements Comparable<Island>{
		int from, to;
		double cost;
		public Island(int from, int to) {
			this.from = from;
			this.to = to;
			this.cost = tax * (Math.pow(xy[from][0] - xy[to][0],2) + Math.pow(xy[from][1] - xy[to][1], 2));
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
			xy = new int[n][2];
			adj = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				adj[i] = new ArrayList<>();
			}
			for (int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int i = 0; i < n; i++) {
					xy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			tax = Double.parseDouble(br.readLine().trim());
			for (int i = 0; i < n-1; i++) {
				for (int j = i+1; j < n; j++) {
					adj[i].add(new Island(i,j));
					adj[j].add(new Island(j,i));
				}
			}
			
			PriorityQueue<Island> queue = new PriorityQueue<>();
			boolean check[] = new boolean[n];
			double key[] = new double[n];
			int p[] = new int[n];
			int cnt = 0;
			Arrays.fill(key, Double.MAX_VALUE);
			check[0] = true;
			key[0] = 0;
			p[0] = -1;
			queue.addAll(adj[0]);
			while(!queue.isEmpty()) {
				Island cur = queue.poll();
				if(check[cur.to]) continue;
				check[cur.to] = true;
				key[cur.to] = cur.cost;
				p[cur.to] = cur.from;
				queue.addAll(adj[cur.to]);
				if(++cnt == n-1) break;
			}
			
			double answer = 0;
			for (int i = 0; i < n; i++) {
				answer += key[i];
			}
			bw.write(String.format("#%d %.0f\n", tc, answer));
		}
		bw.flush();
		bw.close();
	}
	
}
