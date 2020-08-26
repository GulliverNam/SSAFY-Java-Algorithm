package swea.d4;

import java.util.Scanner;

public class Solution_D4_5684_운동 {
	
	static int N, M, start, roads[][];
	static long memo[];
	static long answer;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			roads = new int[N+1][N+1];
			memo = new long[N+1];
			answer = Long.MAX_VALUE;
			for (int i = 0; i < M; i++) {
				roads[sc.nextInt()][sc.nextInt()] = sc.nextInt();
			}
			for (int i = 1; i <= N; i++) {
				start = i;
				workOut(i, 0, new boolean [N+1]);
			}
			System.out.println("#"+tc+" "+(answer == Long.MAX_VALUE ? -1:answer));
		}
		sc.close();
	}

	private static void workOut(int now, long dist, boolean visited[]) {
		if(start == now && visited[start]) {
			answer = Math.min(answer, dist);
			return;
		}
		if(visited[now]) // 출발점이 아닌 사이클은 관심이 없음
			return;
		visited[now] = true;
		for (int i = 1; i <= N; i++) {
			if(roads[now][i] != 0 && dist+roads[now][i] < answer) { // 
				workOut(i, dist+roads[now][i], visited);
			}
		}
		
	}

}
