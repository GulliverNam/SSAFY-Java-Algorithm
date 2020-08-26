package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Solution_2382_미생물격리2 {
	
	static int N, M, K;
	static LinkedList<int[]> micro = new LinkedList<int[]>();
	static int dr[] = {0,-1,1,0,0};
	static int dc[] = {0,0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/test/Solution_2382_미생물격리.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			micro.clear();
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine().trim());
				micro.offer(new int[] {Integer.parseInt(st.nextToken()),
									 Integer.parseInt(st.nextToken()),
									 Integer.parseInt(st.nextToken()),
									 Integer.parseInt(st.nextToken())});
			}
			
			for (int t = 0; t < M; t++) {
				int size = micro.size();
				for (int i = 0; i < size; i++) {
					int cur[] = micro.poll();
					cur[0] += dr[cur[3]];
					cur[1] += dc[cur[3]];
					if(cur[0] == 0 || cur[1] == 0 || cur[0] == N-1 || cur[1] == N-1) {
						cur[3] = cur[3] % 2 == 0 ? cur[3] - 1 : cur[3] + 1;
						cur[2] /= 2;
						if(cur[2] == 0)
							continue;
					}
					micro.offer(cur);
				}
				Collections.sort(micro, new Comparator<int[]>() {
					@Override
					public int compare(int[] o1, int[] o2) {
						if(o1[0] == o2[0] && o1[1] == o2[1])
							return o1[2] - o2[2];
						else if(o1[0] == o2[0])
							return o1[1] - o2[1];
						return o1[0] - o2[0];
					}
				});
				size = micro.size();
				int prev[] = micro.poll();
				boolean dup = false;
				int sum = prev[2];
				for (int i = 1; i < size; i++) {
					int next[] = micro.poll();
					if(!dup) {
						if(prev[0] == next[0] && prev[1] == next[1]) {
							dup = true;
							sum += next[2];
						}
						else {
							sum = next[2];
							micro.offer(prev);
						}
					} else {
						if(prev[0] == next[0] && prev[1] == next[1]) {
							sum += next[2];
						}
						else {
							dup = false;
							prev[2] = sum;
							micro.offer(prev);
							sum = next[2];
						}
					}
					if(i == size - 1) {
						next[2] = sum;
						micro.offer(next);
					}
					prev = next.clone();
				}
			}
			int answer = 0;
			for (int[] m : micro) {
				answer += m[2];
			}
			System.out.println("#"+tc+" "+answer);
		}
		
	}
}
