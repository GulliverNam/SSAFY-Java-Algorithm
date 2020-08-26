package swea.test;

import java.io.*;
import java.util.*;

public class Solution_1949_등산로조성 {

	static int N, K, answer, map[][], dir[][]= {{-1,0},{1,0},{0,-1},{0,1}};
	static List<int[]> points = new ArrayList<int[]>(5);
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/test/Solution_1949_등산로조성.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			answer = 0;
			int max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > max) {
						max = map[i][j];
						points.clear();
						points.add(new int[] {i,j});
					}
					else if(map[i][j] == max)
						points.add(new int[] {i,j});
				}
			}
			for (int[] p : points) {
				makeRoute(p[0], p[1], 1, false, new boolean[N][N]);
			}
			points.clear();
			
			System.out.println("#"+tc+" "+answer);
		}
		

	}

	private static void makeRoute(int r, int c, int length, boolean cut, boolean visited[][]) {
		answer = Math.max(answer, length);
		int nr, nc;
		for (int d = 0; d < 4; d++) {
			nr = r + dir[d][0];
			nc = c + dir[d][1];
			if(nr > -1 && nc > -1 && nr < N && nc < N && !visited[nr][nc]) {
				if(map[r][c] > map[nr][nc]) {
					visited[r][c] = true;
					makeRoute(nr, nc, length+1, cut,visited);
					visited[r][c] = false;
				}
				else if(!cut && map[r][c] <= map[nr][nc]) {
					for (int i = 1; i <= K; i++) {
						if(map[r][c] > map[nr][nc] - i) {
							map[nr][nc] -= i;
							visited[r][c] = true;
							makeRoute(nr, nc, length+1, true, visited);
							visited[r][c] = false;
							map[nr][nc] += i;
						}
					}
				}
					
			}
		}
		
	}

}
