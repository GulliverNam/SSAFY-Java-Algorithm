package swea.test;

import java.io.*;
import java.util.*;

public class Solution_5644_무선충전2 {

	
	static class BC{
		int c, p;

		public BC(int c, int p) {
			this.c = c;
			this.p = p;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			int m = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int[][] walk = new int[2][m];
			List<BC>[][] map = new ArrayList[12][12];
			for (int i = 1; i <= 10; i++) {
				for (int j = 1; j <= 10; j++) {
					map[i][j] = new ArrayList<BC>();
				}
			}
			
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < m; j++) {
					walk[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				BC bc = new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				for (int j = 0; j < map.length; j++) {
					
				}
			}
		}
	}
	

}
