package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로2 {
	static int N, island[][];
	static double tax, answer;
	static boolean visited[];
	static PriorityQueue<Edge> queue = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1, st2;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			island = new int[N][2];
			visited = new boolean[N];
			answer = 0;
			st1 = new StringTokenizer(br.readLine().trim());
			st2 = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				island[i][0] = Integer.parseInt(st1.nextToken());
				island[i][1] = Integer.parseInt(st2.nextToken());
			}
			tax = Double.parseDouble(br.readLine().trim());
			while(!isFinish()) {
				Edge n = queue.poll();
			}
			queue.clear();
			System.out.printf("#%d %.0f\n",tc,answer);
		}
	}
	
	private static boolean isFinish() {
		for (int i = 0; i < N-1; i++) {
				return false;
		}
		return true;
	}
	
	private static double getCost(int i1, int i2) {
		return tax * (Math.pow(island[i1][0] - island[i2][0], 2) + Math.pow(island[i1][1] - island[i2][1], 2));
	}
	
	static class Edge implements Comparable<Edge>{
		int v;
		double cost;
		public Edge(int v, double cost) {
			this.v = v;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.cost, o.cost);
		}
	}
}
