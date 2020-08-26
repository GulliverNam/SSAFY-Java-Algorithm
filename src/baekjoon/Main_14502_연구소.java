package baekjoon;

import java.io.*;
import java.util.*;

public class Main_14502_연구소 {
	
	static int n, m, answer, map[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static List<int[]> virus;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+2][m+2];
		virus = new ArrayList<int[]>();
		answer = 0;
		Arrays.fill(map[0], -1);
		Arrays.fill(map[n+1], -1);
		for (int i = 1; i <= n; i++) {
			Arrays.fill(map[i], -1);
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2)
					virus.add(new int[] {i,j});
			}
		}
		
		buildWall(1, 1, 0);
		
		System.out.println(answer);
	}
	
	private static void buildWall(int r, int c, int cnt) {
		if(r == n+1) return;
		if(cnt == 3) {
			int temp[][] = new int[n+2][];
			for (int i = 0; i <= n+1; i++) {
				temp[i] = map[i].clone();
			}
			for (int[] v : virus) {
				infection(v[0], v[1], temp);
			}
			answer = Math.max(answer, safeZon(temp));
			return;
		}
		for (int j = c; j <= m; j++) {
			if(map[r][j] == 0) {
				map[r][j] = 1;
				buildWall(r, c+1, cnt+1);
				map[r][j] = 0;
			}
		}
		buildWall(r+1, 1, cnt);
		
	}

	private static void infection(int r, int c, int[][] map) {
		map[r][c] = 2;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(map[nr][nc] == 0) {
				infection(nr, nc, map);
			}
		}
	}
	
	private static int safeZon(int[][] map) {
		int num = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if(map[i][j] == 0) num++;
			}
		}
		return num;
	}

}
