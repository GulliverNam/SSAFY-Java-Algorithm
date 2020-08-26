package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {
	
	static int n, m, answer, map[][];
	static boolean cleaned[][];
	
	static int turnR[] = {0,1,0,-1};
	static int turnC[] = {-1,0,1,0};
	static int backR[] = {-1,0,1,0};
	static int backC[] = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+2][m+2];
		cleaned = new boolean[n+1][m+1];
		
		st = new StringTokenizer(br.readLine().trim());
		int[] cleaner = new int[] {Integer.parseInt(st.nextToken())+1,
							 Integer.parseInt(st.nextToken())+1,
							 Integer.parseInt(st.nextToken())};
		Arrays.fill(map[0], -1);
		Arrays.fill(map[n+1], -1);
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			Arrays.fill(map[i], -1);
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cleaning(cleaner[0], cleaner[1], cleaner[2]);
		System.out.println(answer);
	}

	private static void cleaning(int r, int c, int d) {
		if(!cleaned[r][c])answer++;
		cleaned[r][c] = true;
		int dir = d;
		for (int i = 0; i < 4; i++) {
			int nr = r + turnR[dir];
			int nc = c + turnC[dir];
			if(map[nr][nc] == 0 && !cleaned[nr][nc]) {
				cleaning(nr, nc, (dir+1) % 4);
				return;
			}
			dir = (dir+1) % 4;
		}
		int nr = r + backR[d];
		int nc = c + backC[d];
		if(map[nr][nc] == 0)
			cleaning(nr, nc, d);
		
	}

}
