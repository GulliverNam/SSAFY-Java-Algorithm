package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7699_수지의수지맞은여행 {
	
	static int R, C, answer, map[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/Solution_D4_7699_수지의수지맞은여행.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			answer = 0;
			String str;
			for (int i = 0; i < R; i++) {
				str = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j) - 'A';
				}
			}
			
			trip(0, 0, 1, 1 << map[0][0]);
			System.out.println("#"+tc+" "+answer);
		}
	}
	private static void trip(int r, int c, int cnt, int visited) {
		answer = Math.max(answer, cnt);
		if(cnt == 26)
			return;
		int nr, nc;
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if(nr > -1 && nc > -1 && nr < R && nc < C && (visited & 1 << map[nr][nc]) == 0)
				trip(nr, nc, cnt + 1 , visited | 1 << map[nr][nc]);
		}
		
	}

}
