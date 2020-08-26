package swea.test;

import java.io.*;
import java.util.*;

public class Solution_4014_활주로건설2 {
	
	static int n, x;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/test/Solution_4014_활주로건설.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 0;
			// 가로 체크
			top:
			for (int i = 0; i < n; i++) {
				int prev = 0;
				int j = 0;
				while(true) {
					int now = map[i][j];
					while(++j < n && now == map[i][j] ) {
						now = map[i][j];
					}
					if(j >= n) break;
					if(Math.abs(map[i][j] - now) > 1) {
						continue top;
					}
					if(map[i][j] - now == 1) {
						if(j - prev < x) continue top;
						if(!seqCheckR(i, prev, j))
							continue top;
						prev = j;
					} else if(map[i][j] - now == -1) {
						if(j+x > n) continue top;
						if(!seqCheckR(i, j, j+x))
							continue top;
						j += x-1;
						prev = j+1;
					}
					
				}
				answer++;
			}
			
			
			// 세로 체크
			top:
			for (int i = 0; i < n; i++) {
				int prev = 0;
				int j = 0;
				while(true) {
					int now = map[j][i];
					while(++j < n && now == map[j][i] ) {
						now = map[j][i];
					}
					if(j >= n) break;
					if(Math.abs(map[j][i] - now) > 1) {
						continue top;
					}
					if(map[j][i] - now == 1) {
						if(j - prev < x) continue top;
						if(!seqCheckC(i, prev, j))
							continue top;
						prev = j;
					} else if(map[j][i] - now == -1) {
						if(j+x > n) continue top;
						if(!seqCheckC(i, j, j+x))
							continue top;
						j += x-1;
						prev = j+1;
					}
					
				}
				answer++;
			}
			bw.write("#"+tc+" "+answer+"\n");
		}
		bw.flush();
		bw.close();
	}

	private static boolean seqCheckC(int c, int from, int to) {
		int num = map[from][c];
		for (int i = from+1; i < to; i++) {
			if(num != map[i][c]) return false;
		}
		
		return true;
	}

	private static boolean seqCheckR(int r, int from, int to) {
		int num = map[r][from];
		for (int i = from+1; i < to; i++) {
			if(num != map[r][i]) return false;
		}
		
		return true;
	}

}
