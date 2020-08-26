package swea.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로 {

	static int N, clients[][], answer;
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d5/Solution_D5_1247_최적경로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			clients = new int[N+2][2];
			visited = new boolean[N+2];
			answer = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N+2; i++) {
				clients[i][0] = Integer.parseInt(st.nextToken());
				clients[i][1] = Integer.parseInt(st.nextToken());
			}
			visit(0, 0, 0);
			System.out.println("#"+tc+" "+answer);
		}
	}

	private static void visit(int cnt, int cur, int dist) {
		if(dist >= answer)
			return;
		if(cnt == N) {
			dist += Math.abs(clients[cur][0] - clients[1][0]) + Math.abs(clients[cur][1] - clients[1][1]);
			answer = Math.min(answer, dist);
			return;
		}
		for (int i = 2; i < N+2; i++) {
			if(!visited[i]) {
				visited[i] = true;
				visit(cnt+1, i, dist + Math.abs(clients[cur][0]-clients[i][0]) + Math.abs(clients[cur][1]-clients[i][1]));
				visited[i] = false;
			}
		}
		
	}

}
