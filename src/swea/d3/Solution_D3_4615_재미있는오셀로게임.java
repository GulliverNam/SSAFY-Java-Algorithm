package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_4615_재미있는오셀로게임 {
	
	
	static int N, M, Map[][];
	static int Dir[][] = {{-1,-1},{-1,0},{-1,1},
						  {0, -1},       {0, 1},
						  {1, -1},{1, 0},{1, 1}};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_4615_재미있는오셀로게임.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		int white, black;
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			Map = new int[N+1][N+1];
			white = black = 0;
			for (int i = N/2; i <= N/2+1; i++) {
				for (int j = N/2; j <= N/2+1; j++) {
					if((i^j) == 0) Map[i][j] = 2;
					else Map[i][j] = 1;
				}
			}
			int r, c, dol;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				r = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				dol = Integer.parseInt(st.nextToken());
				play(r, c, dol);
			}
			for (int[] map : Map) {
				for (int m : map) {
					if(m == 1) black++;
					else if(m == 2) white++;
				}
			}
			System.out.println("#"+testCase+" "+black+" "+white);
		}
	}
	private static void play(int r, int c, int dol) {
		int nr, nc;
		for (int i = 0; i < 8; i++) {
			nr = r + Dir[i][0];
			nc = c + Dir[i][1];
			if(nr > 0 && nc > 0 && nr <= N && nc <= N && (Map[nr][nc] | dol)  == 3) {
				if(isPossible(nr, nc, i, dol, false)) {
					Map[r][c] = dol;
					while(Map[nr][nc] != dol) {
						Map[nr][nc] = dol;
						nr += Dir[i][0];
						nc += Dir[i][1];
					}
				}
			}
		}
	}

	private static boolean isPossible(int r, int c,int dir, int dol, boolean me) {
		if(me) return true;
		int nr = r + Dir[dir][0];
		int nc = c + Dir[dir][1];
		if(nr > N || nr < 1 || nc > N || nc < 1 || Map[nr][nc] == 0)
			return false;
		if(Map[nr][nc] == dol)
			me = true;
		return isPossible(nr,nc,dir,dol,me);
	}

}
