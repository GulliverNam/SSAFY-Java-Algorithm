package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16973_직사각형탈출 {
	
	static int N, M, H, W;
	static boolean map[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		boolean visited[][] = new boolean[N][M];
		map = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				if(Integer.parseInt(st.nextToken()) == 1)
					map[i][j] = true;
			}
		}
		st = new StringTokenizer(br.readLine().trim());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		int sr = Integer.parseInt(st.nextToken()) - 1;
		int sc = Integer.parseInt(st.nextToken()) - 1;
		int er = Integer.parseInt(st.nextToken()) - 1;
		int ec = Integer.parseInt(st.nextToken()) - 1;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {sr,sc,0});
		visited[sr][sc] = true;
		int cur[], nr, nc, answer = -1;
		int dr[] = {-1,1,0,0};
		int dc[] = {0,0,-1,1};
		top:
		while(!queue.isEmpty()) {
			cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				nr = cur[0]+dr[i];
				nc = cur[1]+dc[i];
				if(nr > -1 && nr < N && nc > -1 && nc < M
						&& !visited[nr][nc] && checkNext(i,cur[0],cur[1])) {
					if(nr == er && nc == ec) {
						answer = cur[2]+1;
						break top;
					}
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc, cur[2]+1});
				}
			}
		}
		System.out.println(answer);
	}
	
	private static boolean checkNext(int dir, int r, int c) {
		int nr = r, nc = c;
		switch(dir) {
			case 0: nr = r - 1; break;
			case 1: nr = r + H; break;
			case 2: nc = c - 1; break;
			case 3: nc = c + W; break;
		}
		if(nr < 0 || nr >= N || nc < 0 || nc >= M) return false;
		switch(dir) {
			case 0: 
			case 1:
				for (int i = c; i < c+W; i++) {
					if(map[nr][i]) return false;
				}
				break;
			case 2:
			case 3:
				for (int i = r; i < r+H; i++) {
					if(map[i][nc]) return false;
				}
				break;
		}
		return true;
	}
}
