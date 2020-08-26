package swea.d4;

import java.io.*;
import java.util.*;

public class Solution_D4_9659_다항식계산 {
	
	static long MOD = 998244353;
	static int N, fs[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			fs = new int[N+1][3];
			for (int i = 2; i <= N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				fs[i][0] = Integer.parseInt(st.nextToken());
				fs[i][1] = Integer.parseInt(st.nextToken());
				fs[i][2] = Integer.parseInt(st.nextToken());
			}
			int M = Integer.parseInt(br.readLine().trim());
			st = new StringTokenizer(br.readLine().trim());
			bw.write("#"+tc+" ");
			for (int i = 0; i < M; i++) {
				long x = Long.parseLong(st.nextToken());
				bw.write(f(N, x, new long[N+1])+" ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

	private static long f(int n, long x, long[] memo) {
		if(n == 0) return 1;
		else if(n == 1) return x;
		if(memo[n] != 0)
			return memo[n];
		switch(fs[n][0]) {
		case 1:
			memo[n] = (f(fs[n][1], x, memo) % MOD + f(fs[n][2], x, memo) % MOD) % MOD; 
			break;
		case 2:
			memo[n] = (fs[n][1] % MOD * f(fs[n][2], x, memo) % MOD) %MOD;
			break;
		case 3:
			memo[n] = (f(fs[n][1], x, memo) % MOD * f(fs[n][2], x, memo) % MOD) % MOD;
			break;
		}
		return memo[n];
	}
	
}

