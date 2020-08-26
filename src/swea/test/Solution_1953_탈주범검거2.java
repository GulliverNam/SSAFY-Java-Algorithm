package swea.test;

import java.io.*;
import java.util.*;

public class Solution_1953_탈주범검거2 {
	
	static int n, m;
	
 	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/test/Solution_1953_탈주범검거.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		int[][] tmp = {{1,2,5,6},
					   {1,2,4,7},
					   {1,3,4,5},
					   {1,3,6,7}};
		boolean[][] route = new boolean[4][8];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				route[i][tmp[i][j]] = true;
			}
		}
		boolean[][] next = {{false,false,false,false},
							{true,true,true,true},
							{true,true,false,false},
							{false,false,true,true},
							{true,false,false,true},
							{false,true,false,true},
							{false,true,true,false},
							{true,false,true,false}};
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int[][] map = new int[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			boolean[][] visited = new boolean[n][m];
			Queue<int[]> queue = new ArrayDeque<int[]>();
			queue.add(new int[] {r,c,- 1, 1});
			visited[r][c] = true;
			int answer = 1;
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				if(cur[3] == l) break;
				for (int i = 0; i < 4; i++) {
					if(next[map[cur[0]][cur[1]]][i]) {
						int nr = cur[0] + dr[i];
						int nc = cur[1] + dc[i];
						if(isIn(nr,nc) && !visited[nr][nc]) {
							if(route[i][map[nr][nc]]) {
								visited[nr][nc] = true;
								queue.add(new int[] {nr,nc,i,cur[3]+1});
								answer++;
							}
						}
					}
				}
			}
			
			bw.write("#"+tc+" "+answer+"\n");
		}
		bw.flush();
		bw.close();
	}

	private static boolean isIn(int nr, int nc) {
		return nr > -1 && nr < n && nc > -1 && nc < m;
	}

}
