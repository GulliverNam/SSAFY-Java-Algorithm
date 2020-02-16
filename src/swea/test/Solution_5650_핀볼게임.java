package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5650_핀볼게임 {
	
	static int N, map[][], wormHole[][][], sr, sc, answer;
	static int dir[][] = {{1,0},{0,-1},{-1,0},{0,1}};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/test/Solution_5650_핀볼게임.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int [N+2][N+2];
			wormHole = new int[11][2][2];
			answer = 0;
			for (int i = 0; i < N+2; i++) {
				Arrays.fill(map[i], 5);
			}
			for (int i = 6; i < 11; i++) {
				Arrays.fill(wormHole[i][0], -1);
				Arrays.fill(wormHole[i][1], -1);
			}
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 1; j <= N; j++) {
					int num = Integer.parseInt(st.nextToken());
					map[i][j] = num;
					if(num >= 6 && num <= 10) {
						if(wormHole[num][0][0] == -1) {
							wormHole[num][0][0] = i;
							wormHole[num][0][1] = j;
						} else {
							wormHole[num][1][0] = i;
							wormHole[num][1][1] = j;
						}
					}
				}
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(map[i][j] == 0) {
						sr = i;
						sc = j;
						for (int d = 0; d < 4; d++) {
							play(i, j, d);
						}
					}
				}
			}
			System.out.println("#"+testCase+" "+answer);
		}
		
	}
	private static void play(int r, int c, int d) {
		int nr = r;
		int nc = c;
		int num = 0, cnt = 0, wh[][];
		while(true) {
			nr += dir[d][0];
			nc += dir[d][1];
			num = map[nr][nc];
			if(num == -1 || (nr == sr && nc == sc)) {
				answer = Math.max(answer, cnt);
				break;
			}
			if(num == 0)
				continue;
			else if(num >= 1 && num <= 5) {
				if(num == 5)
					d = (d + 2) % 4;
				else {
					if(d == num % 4)
						d = (d + 1) % 4;
					else if(d == num - 1)
						d = (d + 3) % 4;
					else
						d = (d + 2) % 4;
				}
				cnt++;
			} else {
				wh = wormHole[num];
				if(wh[0][0] == nr && wh[0][1] == nc) {
					nr = wh[1][0];
					nc = wh[1][1];
				}
				else {
					nr = wh[0][0];
					nc = wh[0][1];
				}
			}
		}
		return;
	}
}
