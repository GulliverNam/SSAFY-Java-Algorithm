package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7194_화섭이의미생물배양2 {
	
	static int params[];
	static int min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			params = new int[4];
			min = Integer.MAX_VALUE;
			// s t a b
			for (int i = 0; i < 4; i++)
				params[i] = Integer.parseInt(st.nextToken());
			
			if(params[3]==1) {
				if((params[1] - params[0])%params[2] == 0) {
					min = (params[1] - params[0]) / params[2];
				}
			}else
				dfs(params[1], 0);
			System.out.println("#"+tc+" "+(min == Integer.MAX_VALUE ? -1 : min));
		}
	}
	private static void dfs(int now, int cnt) {
		if(now == params[0]) {
			min = Math.min(min, cnt);
			return;
		}
		else if(now < params[0])
			return;
		
		if(now % params[3] == 0) {
			dfs(now / params[3], cnt+1);
			dfs(now - params[2], cnt+1);
		}else {
			dfs(now - params[2], cnt+1);
		}
		
	}
}
