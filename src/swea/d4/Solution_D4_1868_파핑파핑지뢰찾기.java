package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D4_1868_파핑파핑지뢰찾기 {
	
	static char map[][];
	static boolean visited[][];
	static int dr[] = {-1,-1,-1,0,0,1,1,1};
	static int dc[] = {-1,0,1,-1,1,-1,0,1};
	static int total;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			map = new char[N+2][N+2];
			visited = new boolean[N+1][N+1];
			total = N*N;
			for (int i = 1; i <= N; i++) {
				String str = br.readLine().trim();
				for (int j = 1; j <= N; j++) {
					map[i][j] = str.charAt(j-1);
				}
			}
			int answer = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(map[i][j]=='.' && isZero(i,j) && !visited[i][j]) {
						dfs(i,j);
						answer++;
					}
					else if(map[i][j] == '*')
						total--;
				}
			}
			System.out.println("#"+tc+" "+(answer+total));
		}
	}
	
	private static boolean isZero(int r, int c) {
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(map[nr][nc] == '*')
				return false;
		}
		return true;
	}

	private static void dfs(int r, int c) {
		total--;
		visited[r][c] = true;
		if(!isZero(r,c)) return;
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(map[nr][nc] == '.' && !visited[nr][nc])
				dfs(nr, nc);
		}
	}

}
