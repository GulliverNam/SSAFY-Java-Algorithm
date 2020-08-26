package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2636_치즈 {
	
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static List<int[]> remove;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		 map = new int[r+2][c+2];
		int total = 0;
		
		Arrays.fill(map[0], -1);
		Arrays.fill(map[r+1], -1);
		for (int i = 1; i <= r; i++) {
			st = new StringTokenizer(br.readLine().trim());
			Arrays.fill(map[i], -1);
			for (int j = 1; j <= c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) total++;
			}
		}
		int time = 0;
		int prev = 0;
		while(true) {
			if(total == 0) break;
			prev = total;
			boolean[][] visited = new boolean[r+2][c+2];
			remove = new ArrayList<int[]>();
			dfs(1,1,visited);
			for (int[] tmp : remove) {
				map[tmp[0]][tmp[1]] = 0;
				total--;
			}
			time++;
		}
		System.out.println(time+"\n"+prev);
	}

	private static void dfs(int r, int c, boolean[][] visited) {
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(!visited[nr][nc]) {
				if(map[nr][nc] == 0) {
					dfs(nr, nc, visited);
				} else if(map[nr][nc] == 1) {
					visited[nr][nc] = true;
					remove.add(new int[] {nr,nc});
				}
			}
		}
		
	}


}
