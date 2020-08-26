package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2105_디저트카페2 {
	
	static int N, sr, sc, answer, map[][];
	static int dr[] = {1,1,-1,-1};
	static int dc[] = {1,-1,-1,1};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/test/Solution_2105_디저트카페.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N+2][N+2];
			answer = -1;
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			top:
			for (int i = 1; i <= N-2; i++) {
				for (int j = 2; j <= N-1; j++) {
					sr = i;
					sc = j;
					boolean visited[] = new boolean[101];
					visited[map[i][j]] = true;
					tour(i, j, 0, 1, visited);
					if(answer == 2*(N-1))
						break top;
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}

	private static void tour(int r, int c, int dir, int cnt, boolean visited[]) {
		int nr, nc;
		for (int d = dir, next = dir == 3? dir:dir+1; d <= next; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			if(nr == sr && nc == sc) {
				answer = Math.max(answer, cnt);
				return;
			}
			if(map[nr][nc] != 0 && nr >= sr && !visited[map[nr][nc]]) {
				visited[map[nr][nc]] = true;
				tour(nr, nc, d, cnt+1, visited);
				visited[map[nr][nc]] = false;
			}
		}
		
	}
}
