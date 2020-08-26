package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2623_음악프로그램 {

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
			int size = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			for (int j = 1; j < size; j++) {
				int to = Integer.parseInt(st.nextToken());
				if(link[from] == null) link[from] = new ArrayList<Integer>();
				link[from].add(to);
				count[to]++;
				from = to;
			}
		}
		for (int i = 1; i <= N; i++) {
			if(count[i] == 0)
				queue.offer(i);
		}
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			bw.write(cur+"\n");
			if(link[cur] != null){
				for (int to : link[cur]) {
					if(--count[to] == 0)
						queue.offer(to);
				}	
			}
		}
		for (int i = 1; i <= N; i++) {
			if(count[i] != 0) {
				System.out.println("0");
				return;
			}
		}
		bw.flush();
		bw.close();
	}

}
