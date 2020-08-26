package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {
	
	static int M, N, K, dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new boolean[N+2][M+2];
			int r,c;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine().trim());
				c = Integer.parseInt(st.nextToken());
				r = Integer.parseInt(st.nextToken());
				map[r+1][c+1] = true;
			}
			LinkedList<int[]> queue = new LinkedList<>();
			int cur[], nr, nc, answer = 0;;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if(map[i][j]) {
						queue.offer(new int[] {i,j});
						map[i][j] = false;
						while(!queue.isEmpty()) {
							cur = queue.poll();
							r = cur[0];
							c = cur[1];
							for (int d = 0; d < 4; d++) {
								nr = r + dir[d][0];
								nc = c + dir[d][1];
								if(map[nr][nc]) {
									map[nr][nc] = false;
									queue.offer(new int[] {nr,nc});
								}
							}
						}
						answer++;
					}
				}
			}
			System.out.println(answer);
		}
	}

}
