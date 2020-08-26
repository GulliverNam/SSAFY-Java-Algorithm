package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2117_홈방범서비스 {
	
	static int N, M, answer;
	static boolean map[][];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/test/Solution_2117_홈방범서비스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new boolean[N][N];
			answer = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					if(st.nextToken().equals("1"))
						map[i][j] = true;
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					security(i,j);
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
		
	}

	private static void security(int r, int c) {
		int k = 0, benefit = 0, d, cnt = 0;
		 do{
			for (int i = -k; i <= k; i++) {
				d = k-Math.abs(i);
				if(d == 0) {
					if(r+d > -1 && r+d < N && c+i > -1 && c+i < N && map[r+d][c+i]) {
						cnt++;
						benefit += M;
					}
					benefit--;
				} else {
					if(r+d > -1 && r+d < N && c+i > -1 && c+i < N && map[r+d][c+i]) {
						cnt++;
						benefit += M;
					}
					if(r-d > -1 && r-d < N && c+i > -1 && c+i < N && map[r-d][c+i]) {
						cnt++;
						benefit += M;
					}
					benefit -= 2;
				}
			}
			if(benefit >= 0)
				answer = Math.max(answer, cnt);
			k++;
		} while(k <= N);
		
	}

}
