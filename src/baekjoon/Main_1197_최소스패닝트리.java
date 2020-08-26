package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1197_최소스패닝트리 {
	
	static PriorityQueue<Tree> queue = new PriorityQueue<>();
	static int[] parents, rank;
	
	static class Tree implements Comparable<Tree>{
		int from, to, cost;
		
		public Tree(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Tree o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		parents = new int[V+1];
		rank = new int[V+1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine().trim());
			queue.offer(new Tree(Integer.parseInt(st.nextToken()),
								 Integer.parseInt(st.nextToken()),
								 Integer.parseInt(st.nextToken())));
		}
		
		for (int i = 1; i <= V; i++) {
			makeSet(i);
		}
		
		int cnt = 0;
		int answer = 0;
		while(cnt != V-1) {
			Tree cur = queue.poll();
			if(findSet(cur.from) == findSet(cur.to))
				continue;
			union(cur.from, cur.to);
			answer += cur.cost;
			cnt++;
		}
		System.out.println(answer);
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
		if(rank[px] > rank[py]) {
			parents[py] = px;
		} else {
			parents[px] = py;
			if(rank[px] == rank[py])
				rank[px]++;
		}
	}
	
}
