package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2468_안전영역_BFS {
	static int N, map[][], dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean check[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N+2][N+2];
		check = new boolean[N+2][N+2];
		int maxHeight = 0;
		int minHeight = 101;
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, map[i][j]);
				minHeight = Math.min(minHeight, map[i][j]);
			}
		}
		for(int i = minHeight-1;i < maxHeight; i++) {
			answer = Math.max(answer, bfs(i));
			for (int j = 1; j <= N; j++) {
				Arrays.fill(check[j], false);
			}
		}
		System.out.println(answer);
	}

	private static int bfs(int limit) {
		LinkedList<int[]> queue = new LinkedList<>();
		int count = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(!check[i][j] && map[i][j] > limit) {
					queue.offer(new int[] {i,j});
					check[i][j] = true;
					int cur[], r, c, nr, nc;
					while(!queue.isEmpty()) {
						cur = queue.poll();
						r = cur[0];
						c = cur[1];
						for (int d = 0; d < 4; d++) {
							nr = r + dir[d][0];
							nc = c + dir[d][1];
							if(!check[nr][nc] && map[nr][nc] > limit) {
								check[nr][nc] = true;
								queue.offer(new int[] {nr,nc});
							}
						}
					}
					count++;
				}
			}
		}
		return count;
		
	}

}