package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {
	
	static boolean visited[][];
	static int N, M, L, map[][], answer;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int dir[][]= {{0},
						 {0,1,2,3},
						 {0,1},
						 {2,3},
						 {0,3},
						 {1,3},
						 {1,2},
						 {0,2}};
	static int disconnect[][] = {{3,4,7},
							  {3,5,6},
							  {2,6,7},
							  {2,4,5}};
 	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/test/Solution_1953_탈주범검거.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		int r,c;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N+2][M+2];
			visited = new boolean[N+2][M+2];
			answer = 0;
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 1; j <= M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			tracking(r+1,c+1,0,-1);
			System.out.println("#"+tc+" "+answer);
		}
	}

	private static void tracking(int r, int c, int cnt, int prev) {
		if(cnt == L)
			return;
		if(!visited[r][c])
			answer++;
		visited[r][c] = true;
		int nr, nc, d[] = dir[map[r][c]];
		top:
		for (int i : d){
			if(i != prev) {
				nr = r + dr[i];
				nc = c + dc[i];
				if(map[nr][nc] != 0) {
					for (int j: disconnect[i])
						if(map[nr][nc] == j) continue top;
					tracking(nr, nc, cnt+1, (i % 2 == 0 ? i+1:i-1));
				}
			}
		}
	}

}
