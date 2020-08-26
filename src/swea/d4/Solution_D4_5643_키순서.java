package swea.d4;

import java.io.*;
import java.util.*;

public class Solution_D4_5643_키순서 {
	
	static int n, m, cnt;
	static List<Integer>[] prev;
	static List<Integer>[] next;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine().trim());
			m = Integer.parseInt(br.readLine().trim());
			prev = new ArrayList[n+1];
			next = new ArrayList[n+1];
			visited = new boolean[n+1];
			
			for (int i = 1; i <= n; i++) {
				prev[i] = new ArrayList<Integer>();
				next[i] = new ArrayList<Integer>();
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int small = Integer.parseInt(st.nextToken());
				int tall = Integer.parseInt(st.nextToken());
				prev[tall].add(small);
				next[small].add(tall);
			}
			
			int answer = 0;
			for (int i = 1; i <= n; i++) {
				cnt = 0;
				dfs(i, prev);
				Arrays.fill(visited, false);
				dfs(i, next);
				Arrays.fill(visited, false);
				if(cnt == n-1)
					answer++;
			}
			bw.write("#"+tc+" "+answer+"\n");
		}
		bw.flush();
		bw.close();
		
	}


	private static void dfs(int now, List<Integer>[] list) {
		visited[now] = true;
		for (int p : list[now]) {
			if(!visited[p]) {
				cnt++;
				dfs(p, list);
			}
		}
		
		
	}

}

