package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1194_달이차오른다가자 {
	
	static int n, m;
	static int answer;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static char[][] map;
	static boolean[][][] visited;
	static Queue<int[]> queue;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n+2][m+2];
		visited = new boolean[n+2][m+2][1 << 6];
		int[] start = new int[4];
		for (int i = 1; i <= n; i++) {
			char[] line = br.readLine().trim().toCharArray();
			for (int j = 1; j <= m; j++) {
				map[i][j] = line[j-1];
				if(map[i][j] == '0') {
					map[i][j] = '.';
					start[0] = i;
					start[1] = j;
					// count
					start[2] = 0;
					// mask
					start[3] = 0;
				}
			}
		}
		answer = -1;
		queue = new ArrayDeque<int[]>();
		queue.add(start);
		visited[start[0]][start[1]][start[3]] = true;
		top:
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if(!visited[nr][nc][cur[3]]) {
					if(map[nr][nc] == '.') {
						visited[nr][nc][cur[3]] = true;
						queue.add(new int[] {nr,nc,cur[2]+1,cur[3]});
					} else if(map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
						int idx = map[nr][nc]-'a';
						visited[nr][nc][cur[3]] = true;
						queue.add(new int[] {nr,nc,cur[2]+1,cur[3] | 1<<idx});
					} else if(map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
						if((cur[3] & 1 << map[nr][nc] - 'A') != 0) {
							visited[nr][nc][cur[3]] = true;
							queue.add(new int[] {nr,nc,cur[2]+1,cur[3]});
						}
					} else if(map[nr][nc] == '1') {
						answer = cur[2] + 1;
						break top;
					}
				}
			}
		}
		System.out.println(answer);
	}
}
