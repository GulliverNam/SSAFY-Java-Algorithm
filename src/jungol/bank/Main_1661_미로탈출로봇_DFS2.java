package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1661_미로탈출로봇_DFS2 {
	static int Maze[][], C, R, Dc, Dr, Answer = Integer.MAX_VALUE;
	static int Dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static int Visit[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/bank/Main_1661_미로탈출로봇.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Maze = new int[R+1][C+1];
		Visit = new int[R+1][C+1];
		st = new StringTokenizer(br.readLine().trim(), " ");
		int sc = Integer.parseInt(st.nextToken());
		int sr = Integer.parseInt(st.nextToken());
		Dc = Integer.parseInt(st.nextToken());
		Dr = Integer.parseInt(st.nextToken());
		
		char[] c;
		for (int i = 1; i <= R; i++) {
			c = br.readLine().toCharArray();
			for (int j = 1; j <= C; j++) {
				Maze[i][j] = c[j-1] - '0';
			}
		}
		dfs(sr, sc, 1);
		System.out.println(Answer-1);
	}
	private static void dfs(int r, int c, int cnt) {
		if(r == Dr && c == Dc) {
			Answer = Math.min(Answer, cnt);
			return;
		}
		if(cnt >= Answer)
			return;
		if(Visit[r][c] == 0 || Visit[r][c] > cnt) {
			Visit[r][c] = cnt ;
			int nr, nc;
			for (int i = 0; i < 4; i++) {
				nr = r + Dir[i][0];
				nc = c + Dir[i][1];
				if(nr > 0 && nc > 0 && nr <= R && nc <= C &&
				   (Visit[nr][nc] == 0 || Visit[nr][nc] > cnt) && Maze[nr][nc] == 0) {
					dfs(nr,nc,cnt+1);
				}
			}
		}
	}

}
