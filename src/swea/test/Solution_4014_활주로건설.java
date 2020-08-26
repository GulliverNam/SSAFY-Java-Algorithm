package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설 {

	static int N, X, map[][], answer;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/test/Solution_4014_활주로건설.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			answer = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				build(i, true);
				build(i, false);
			}
			
			System.out.println("#"+tc+" "+answer);
		}
	}

	private static void build(int i, boolean horizon) {
		int prev = 0, cnt = 0;
		int max = 0;
		boolean up = false, down = false;
		if(horizon) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, map[i][j]);
				if(prev == map[i][j]) {
					cnt++;
				} else {
					if(prev != 0) {
						if(prev < map[i][j]) {
							up = true;
						} else {
							down = true;
							up = false;
						}
						if(Math.abs(prev-map[i][j]) > 1)
							return;
						if(max > prev) {
							if(up && down) {
								if(cnt < 2*X)
									return;
								else {
									down = false;
								}
							}
							else if((up || down) && cnt < X)
								return;
						}
					}
					cnt = 1;
					prev = map[i][j];
				}
				if(j == N-1 && max > prev && down && cnt < X)
					return;
			}
			answer++;
		} else {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, map[j][i]);
				if(prev == map[j][i]) {
					cnt++;
				} else {
					if(prev != 0) {
						if(prev < map[j][i]) {
							up = true;
						} else {
							down = true;
							up = false;
						}
						if(Math.abs(prev-map[j][i]) > 1)
							return;
						if(max > prev) {
							if(up && down) {
								if(cnt < 2*X)
									return;
								else {
									down = false;
								}
							}
							else if((up || down) && cnt < X)
								return;
						}
					}
					cnt = 1;
					prev = map[j][i];
				}
				if(j == N-1 && max > prev && down && cnt < X)
					return;
			}
			answer++;
		}
	}
}
