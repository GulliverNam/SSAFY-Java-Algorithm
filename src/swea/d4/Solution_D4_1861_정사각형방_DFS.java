package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방_DFS {
	
	static int N, room[][], max, answer, sr, sc;
	static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/Solution_D4_1861_정사각형방.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine().trim());
			room = new int[N+2][N+2];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 1; j <= N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max = 0;
			answer = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					sr = i;
					sc = j;
					dfs(i, j, 1);
				}
			}
			
			System.out.println("#"+testCase+" "+answer+" "+max);
		}
	}

	private static void dfs(int r, int c, int cnt) {
		if(max < cnt) {
			max = cnt;
			answer = room[sr][sc];
		}
		if (max == cnt) {
			answer = Math.min(answer, room[sr][sc]);
		}
		int nr, nc;
		for (int d = 0; d < 4; d++) {
			nr = r + dir[d][0];
			nc = c + dir[d][1];
			if(room[nr][nc] - room[r][c] == 1)
				dfs(nr, nc, cnt+1);
		}
	}

}
