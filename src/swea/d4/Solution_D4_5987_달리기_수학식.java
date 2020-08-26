package swea.d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_D4_5987_달리기_수학식 {
	
	static int N, M, needs[], arr[];
	static long memo[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			needs = new int[N];
			arr = new int[N];
			memo = new long[1<<N];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int f = Integer.parseInt(st.nextToken())-1;
				int g = Integer.parseInt(st.nextToken())-1;
				needs[g] |= (1 << f);
			}
			bw.write("#"+tc+" "+dfs(0, 0)+"\n");
		}
		bw.flush();
		bw.close();
	}

	private static long dfs(int flag, int cnt) {
		if(flag== (1 << N) - 1) {
			return 1;
		} else if(memo[flag] > 0) {
			return memo[flag];
		}
		for (int i = 0; i < N; i++) {
			if((flag & 1 << i) == 0&& (flag & needs[i]) == needs[i]) {
				arr[cnt] = i;
				memo[flag] += dfs(flag | 1 << i, cnt+1);
			}
		}
		return memo[flag];
		
	}

}

