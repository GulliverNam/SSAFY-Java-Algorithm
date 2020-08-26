package baekjoon;

import java.io.*;
import java.util.*;

public class Main_14499_주사위굴리기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] map = new int[n+2][m+2];
		Arrays.fill(map[0], -1);
		Arrays.fill(map[n+1], -1);
		for (int i = 1; i <= n; i++) {
			Arrays.fill(map[i], -1);
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	}

}
