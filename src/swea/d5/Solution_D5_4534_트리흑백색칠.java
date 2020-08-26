package swea.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 자기 자신의 경우의 수: 자신이 흑 일때 경우의 수 + 자신이 백일때 경우의 수
 * 자식들의 경우의 수 : 자식들의 경우의 수를 모두 곱함
 * @author GiwonNam
 */

public class Solution_D5_4534_트리흑백색칠 {
	
	static final int mod = 1000000007;
	static int N;
	static long answer;
	static List<Integer> adj[];
	static long[][] memo; // 색상, 정점 번호
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d5/Solution_D5_4534_트리흑백색칠.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			adj = new ArrayList[N+1];
			memo = new long[2][N+1];
			answer = 0;
			for (int i = 1; i <= N; i++)
				adj[i] = new ArrayList<Integer>();
			
			int prev, next;
			for (int i = 0; i < N-1; i++) {
				st = new StringTokenizer(br.readLine().trim());
				prev = Integer.parseInt(st.nextToken());
				next = Integer.parseInt(st.nextToken());
				adj[prev].add(next);
				adj[next].add(prev);
			}
			answer = (dfs(1, 0, 0) + dfs(1, 1, 0)) % mod;
			System.out.println("#"+tc+" "+answer);
		}

	}
	/**
	 * @param color - 0: black, 1: white
	 */
	private static long dfs(int v, int color, int parent) {
		// memo[color][v] 값이 존재한다면, 다시 계산하지 않고, 해당 값 리턴
		if(memo[color][v] != 0)
			return memo[color][v];
		long ret = 1;
		
		if(color == 0) {
			// color가 흑(0)인 경우
			// 자식 노드들을 백(1)으로 칠한 경우의 수들의 곱
			for (Integer child : adj[v]) {
				if(child != parent) {
					ret *= dfs(child, 1, v);
					ret %= mod;
				}
			}
		}else {
			// color가 백(1)인 경우
			// 자식 노드들을 흑(0)으로 칠한 경우의 수들의 곱
			//				+
			// 자식 노드들을 백(1)으로 칠한 경우의 수들의 곱
			for (Integer child : adj[v]) {
				if(child != parent) {
					ret *= (dfs(child, 0, v) + dfs(child, 1, v)); 
					ret %= mod ;
				}
			}
		}
		
		// memo[color][v]에 기록
		memo[color][v] = ret;
		return ret;
	}

}
