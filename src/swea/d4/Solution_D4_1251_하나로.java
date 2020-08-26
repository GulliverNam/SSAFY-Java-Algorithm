package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로 {
	static int parent[];
	static int N, island[][];
	static double tax, answer;
	static PriorityQueue<Node> queue = new PriorityQueue<>();
	
	private static void makeSet(int v) {
		parent[v] = v;
	}
	private static int findParent(int v) {
		if(parent[v] == v)
			return v;
		return findParent(parent[v]);
	}
	private static void unionSet(int u, int v) {
		parent[findParent(v)] = findParent(u); 
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1, st2;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			island = new int[N][2];
			answer = 0;
			parent = new int[N];
			for (int i = 0; i < N; i++) {
				makeSet(i);
			}
			st1 = new StringTokenizer(br.readLine().trim());
			st2 = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				island[i][0] = Integer.parseInt(st1.nextToken());
				island[i][1] = Integer.parseInt(st2.nextToken());
			}
			tax = Double.parseDouble(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					queue.offer(new Node(i, j, getCost(i,j)));
				}
			}
			while(!isFinish()) {
				Node n = queue.poll();
				if(findParent(n.i) != findParent(n.j)) {
					answer += n.cost;
					unionSet(n.i, n.j);
				}
			}
			queue.clear();
			System.out.printf("#%d %.0f\n",tc,answer);
		}
	}
	
	private static boolean isFinish() {
		for (int i = 0; i < N-1; i++) {
			if(findParent(i) != findParent(i+1))
				return false;
		}
		return true;
	}
	
	private static double getCost(int i1, int i2) {
		return tax * (Math.pow(island[i1][0] - island[i2][0], 2) + Math.pow(island[i1][1] - island[i2][1], 2));
	}
	
	static class Node implements Comparable<Node>{
		int i, j;
		double cost;
		public Node(int i, int j, double cost) {
			this.i = i;
			this.j = j;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return Double.compare(this.cost, o.cost);
		}
	}
}
