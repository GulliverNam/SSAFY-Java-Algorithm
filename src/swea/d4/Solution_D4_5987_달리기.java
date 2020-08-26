package swea.d4;

import java.io.*;
import java.util.*;


public class Solution_D4_5987_달리기 {
	
	static long cache[];
	static int N, M;
	static List<Integer> cases[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			cache = new long[1<<N];
			cases = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				cases[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				cases[Integer.parseInt(st.nextToken())-1].add(Integer.parseInt(st.nextToken())-1);
			}
			Arrays.fill(cache, -1);
			System.out.println("#"+tc+" "+mCase(0));
		}
	}

	private static long mCase(int visited) {
		if(visited == (1 << N) - 1) {
			return cache[visited] = 1;
		} else if(cache[visited] != -1){
			return cache[visited];
		}
		cache[visited] = 0;
		top:
		for (int i = 0; i < N; i++) {
			if((visited & 1 << i) == 0) {
				for (int node : cases[i]) {
					if((visited & 1 << node) == 0)
						continue top;
				}
				cache[visited] += mCase(visited | 1 << i);
			}
		}
		return cache[visited];
		
	}
	
}

