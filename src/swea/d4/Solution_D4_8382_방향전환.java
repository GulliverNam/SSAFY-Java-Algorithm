package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D4_8382_방향전환 {
	
	static int sr, sc, er, ec, answer;
	static boolean visited[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			sc = Integer.parseInt(st.nextToken()) + 100;
			sr = Integer.parseInt(st.nextToken()) + 100;
			ec = Integer.parseInt(st.nextToken()) + 100;
			er = Integer.parseInt(st.nextToken()) + 100;
			answer = Integer.MAX_VALUE;
			if(Math.abs(er-sr) > Math.abs(ec-sc))
				bfs(1);
			else
				bfs(0);
			System.out.println("#"+tc+" "+answer);
		}

	}
	
	private static void bfs(int s) {
		LinkedList<int[]> queue = new LinkedList<>();
		visited = new boolean[201][201];
		queue.offer(new int[] {sr,sc, 0, s});
		visited[sr][sc] = true;
		int cur[];
		while(!queue.isEmpty()) {
			cur = queue.poll();
			if(cur[0] == er && cur[1] == ec) {
				answer = Math.min(answer, cur[2]);
				return;
			}
			switch(cur[3]) {
			case 0:
				if(ec - cur[1] > 0) {
					if(cur[1]+1 < 201 && !visited[cur[0]][cur[1]+1]) {
						visited[cur[0]][cur[1]+1] = true;
						queue.offer(new int[] {cur[0], cur[1]+1, cur[2]+1, 1});
					}
				} else if(ec - cur[1] < 0) {
					if(cur[1]-1 > -1 && !visited[cur[0]][cur[1]-1]) {
						visited[cur[0]][cur[1]-1] = true;
						queue.offer(new int[] {cur[0], cur[1]-1, cur[2]+1, 1});
					}
				} else {
					if(cur[1]+1 < 201 && !visited[cur[0]][cur[1]+1]) {
						visited[cur[0]][cur[1]+1] = true;
						queue.offer(new int[] {cur[0], cur[1]+1, cur[2]+1, 1});
					}
					if(cur[1]-1 > -1 && !visited[cur[0]][cur[1]-1]) {
						visited[cur[0]][cur[1]-1] = true;
						queue.offer(new int[] {cur[0], cur[1]-1, cur[2]+1, 1});
					}
				}
				break;
			case 1:
				if(er - cur[0] > 0) {
					if(cur[0]+1 < 201 && !visited[cur[0]+1][cur[1]]) {
						visited[cur[0]+1][cur[1]] = true;
						queue.offer(new int[] {cur[0]+1, cur[1], cur[2]+1, 0});
					}
				} else if(er - cur[0] < 0) {
					if(cur[0]-1 > -1 && !visited[cur[0]-1][cur[1]]) {
						visited[cur[0]-1][cur[1]] = true;
						queue.offer(new int[] {cur[0]-1, cur[1], cur[2]+1, 0});
					}
				} else {
					if(cur[0]+1 < 201 && !visited[cur[0]+1][cur[1]]) {
						visited[cur[0]+1][cur[1]] = true;
						queue.offer(new int[] {cur[0]+1, cur[1], cur[2]+1, 0});
					}
					if(cur[0]-1 > -1 && !visited[cur[0]-1][cur[1]]) {
						visited[cur[0]-1][cur[1]] = true;
						queue.offer(new int[] {cur[0]-1, cur[1], cur[2]+1, 0});
					}
				}
				break;
			}
		}
	}

}
