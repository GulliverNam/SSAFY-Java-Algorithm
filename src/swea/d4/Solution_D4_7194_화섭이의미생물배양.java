package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7194_화섭이의미생물배양 {
	
	static long params[];
	static long answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			answer = Long.MAX_VALUE;
			params = new long[4];
			// s t a b
			for (int i = 0; i < 4; i++)
				params[i] = Long.parseLong(st.nextToken());
			dfs(params[1], 0);
			System.out.println("#"+tc+" "+(answer == Long.MAX_VALUE ? -1 : answer));
		}
	}
	private static void dfs(long now, long cnt) {
		if(now < params[0] || cnt >= answer) return;
		if(now == params[1]) {
			answer = Math.min(answer, cnt);
			return;
		}
		double num1 = baseLog(params[1] / now, params[3]);
		if(num1 - (long)num1 > 0) {
			System.out.println("now: " + now);
			answer = Math.min(answer, cnt + (long)num1);
		}
		long num2 = params[1] - now;
		if(num2 % params[2] == 0) {
			System.out.println("now: " + now);
			answer = Math.min(answer, cnt + num2 / params[2]);
		}
		if(params[3] != 1) {
			dfs(now*params[3], cnt+1);
			dfs(now+params[2], cnt+1);
		}
	}
	private static double baseLog(double x, double base) {
		System.out.println(Math.log10(x) / Math.log10(base));
		return Math.log10(x) / Math.log10(base);
	}
}
