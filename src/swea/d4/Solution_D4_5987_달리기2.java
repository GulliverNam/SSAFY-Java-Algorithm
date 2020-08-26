package swea.d4;

import java.io.*;
import java.util.*;


public class Solution_D4_5987_달리기2 {
	
	static int N, M;
	static long cases[], memo[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			cases = new long[N];
			memo = new long[1<<N];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int fast = Integer.parseInt(st.nextToken()) - 1;
				int slow = Integer.parseInt(st.nextToken()) - 1;
				cases[slow] |= (1 << fast);
			}
			bw.write("#"+tc+" "+dfs(0)+"\n");
		}
		bw.flush();
		bw.close();
	}

	private static long dfs(int flag) {
		if(flag == (1 << N) -1) {
			return 1;
		}else if(memo[flag] > 0) {
			return memo[flag];
		}
		for (int i = 0; i < N; i++) {
			if((flag & 1 << i) == 0 && (flag & cases[i]) == cases[i]) {
				memo[flag] += dfs(flag | 1 << i);
			}
		}
		return memo[flag];
	}
	
}
