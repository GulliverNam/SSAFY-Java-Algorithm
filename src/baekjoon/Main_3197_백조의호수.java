package baekjoon;

import java.io.*;
import java.util.*;

public class Main_3197_백조의호수 {
	
	static int r, c;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static char[][] map;
	static char[][] border;
	static boolean[][] visited;
	static boolean done;
	static int[] swan;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r+2][c+2];
		swan = new int[2];
		for (int i = 1; i <= r; i++) {
			char[] m = br.readLine().trim().toCharArray();
			for (int j = 1; j <= c; j++) {
				map[i][j] = m[j-1];
				if(map[i][j] == 'L') {
					swan[0] = i;
					swan[1] = j;
				}
			}
		}
		visited = new boolean[r+1][c+1];
		border = new char[r+2][c+2];
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				if(map[i][j] == '.' && !visited[i][j]) {
					getBorder(i,j);
				}
			}
		}
		int answer = 0;
		List<int[]> temp = new ArrayList<int[]>();
		done = false;
		while(!done) {
			for (int i = 1; i <= r; i++) {
				for (int j = 1; j <= c; j++) {
					if(border[i][j] == 'X') {
						border[i][j] = '.';
						map[i][j] = 'L';
						for (int d = 0; d < 4; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];
							if(map[nr][nc] == 'X' && !visited[nr][nc]) {
								visited[nr][nc] = true;
								temp.add(new int[] {nr,nc});
							}
						}
					}
				}
			}
			for (int[] b : temp) {
				border[b[0]][b[1]] = 'X';
			}
			temp.clear();
			isFinish(swan[0], swan[1], new boolean[r+1][c+1]);
			answer++;
		}
		System.out.println(answer);
		
	}

	private static void isFinish(int r, int c, boolean[][] visited) {
		if(done) return;
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(map[nr][nc] == '.' && !visited[nr][nc]) {
				isFinish(nr, nc, visited);
			} else if(map[nr][nc] == 'L' && !visited[nr][nc]) {
				done = true;
				return;
			}
		}
	}

	private static void getBorder(int r, int c) {
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(map[nr][nc] == '.' && !visited[nr][nc]) {
				getBorder(nr, nc);
			} else if(map[nr][nc] == 'X' && !visited[nr][nc]) {
				visited[nr][nc] = true;
				border[nr][nc] = 'X';
			}
			
		}
	}

}
