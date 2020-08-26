package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {

	static ArrayList<Integer>[] node;
	static int N, M, V;
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		node = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for (int i = 1; i <= N; i++)
			node[i] = new ArrayList<Integer>();
		
		int n1, n2;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			node[n1].add(n2);
			node[n2].add(n1);
		}
		for (int i = 1; i <= N; i++) 
			Collections.sort(node[i]);
		
		dfs(V);
		System.out.println();
		Arrays.fill(visited, false);
		bfs();

	}
	private static void dfs(int cur) {
		visited[cur] = true;
		System.out.print(cur+" ");
		for (int next : node[cur]) {
			if(!visited[next])
				dfs(next);
		}
	}

	private static void bfs() {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.offer(V);
		visited[V] = true;
		int cur;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			System.out.print(cur+" ");
			for (int next : node[cur]) {
				if(!visited[next]) {
					visited[next] = true;
					queue.offer(next);
				}
			}
		}
	}
}
