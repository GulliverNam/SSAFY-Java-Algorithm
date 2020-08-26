package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2252_줄세우기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count[] = new int[N+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		List<Integer> link[] = new ArrayList[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if(link[from] == null) 
				link[from] = new ArrayList<Integer>();
			link[from].add(to);
			count[to]++;
		}
		for (int i = 1; i <= N; i++) {
			if(count[i] == 0)
				queue.offer(i);
		}
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			bw.write(cur+" ");
			if(link[cur] != null) {
				for (int to : link[cur]) {
					if(--count[to] == 0)
						queue.offer(to);
				}
			}
		}
		bw.flush();
		bw.close();
	}
}
