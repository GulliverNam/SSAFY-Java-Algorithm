package swea.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {
	
	static int N, map[][], answer, comp;
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			answer = Integer.MAX_VALUE;
			comp = (int)(Math.pow(2, N)-1);
			visited = new boolean[comp];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			divideTwo(0, 0, 0);
			System.out.println("#"+tc+" "+answer);
		}
	}

	private static void divideTwo(int cnt, int selected, int start) {
		if(cnt == N/2) {
			if(!visited[selected] && !visited[comp-selected]) {
				visited[selected] = visited[comp-selected] = true;
				answer = Math.min(answer, getScore(selected));
			}
			return;
		}
		for (int i = start; i < N; i++) {
			divideTwo(cnt+1, selected | 1<<i, i+1);
		}
		
	}

	private static int getScore(int selected) {
		int score1 = 0, score2 = 0;
		for (int i = 0; i < N; i++) {
			if((selected & 1<<i) == 0) {
				for (int j = 0; j < N; j++) {
					if((selected & 1<<j) == 0)
						score1 += map[i][j];
				}
			} else {
				for (int j = 0; j < N; j++) {
					if((selected & 1<<j) != 0)
						score2 += map[i][j];
				}
			}
		}
		return Math.abs(score1-score2);
	}

}
