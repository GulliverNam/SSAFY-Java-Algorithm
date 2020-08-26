package baekjoon;

import java.io.*;
import java.util.*;

public class Main_3190_뱀 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		/**
		 * map에 사과가 있음
		 * 상하좌우 끝에 벽이있음
		 * 시작위치: 1행 1열 / 시작길이: 1
		 */
		int n = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[n+2][n+2];
		Arrays.fill(map[0], -1);
		Arrays.fill(map[n+1], -1);
		// -1:	벽	
		// 0 :	빈칸	
		// 1 :	사과	
		// 2 :	뱀
		map[1][1] = 2;
		for (int i = 1; i <= n; i++) {
			map[i][0] = -1;
			map[i][n+1] = -1;
		}
		int k = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine().trim());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		int time = 0;
		int[] dr = {0,1,0,-1};
		int[] dc = {1,0,-1,0};
		ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] {1,1});
		int dir = 0;
		int l = Integer.parseInt(br.readLine().trim());
		boolean isFinish = false;
		top:
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int t = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			while(time != t) {
				time++;
				int[] head = queue.peekFirst();
				int nr = head[0] + dr[dir];
				int nc = head[1] + dc[dir];
				if(map[nr][nc] == 0) {
					int[] tail = queue.pollLast();
					map[tail[0]][tail[1]] = 0;
				}
				if(map[nr][nc] == -1 || map[nr][nc] == 2) {
					isFinish = true;
					break top;
				}
				map[nr][nc] = 2;
				queue.addFirst(new int[] {nr,nc});
			}
			if(c == 'D') {
				dir = (dir + 1) % 4;
			} else {
				dir = dir - 1 < 0 ? 3:dir-1;
			}
		}
		if(!isFinish) {
			while(true) {
				time++;
				int[] head = queue.peekFirst();
				int nr = head[0] + dr[dir];
				int nc = head[1] + dc[dir];
				if(map[nr][nc] == -1 || map[nr][nc] == 2) {
					break;
				}
				if(map[nr][nc] == 0) {
					int[] tail = queue.pollLast();
					map[tail[0]][tail[1]] = 0;
				}
				map[nr][nc] = 2;
				queue.addFirst(new int[] {nr,nc});
			}
		}
		System.out.println(time);
	}

}
