package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1220_Margnetic {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_1220_Margnetic.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;
		int map[][], N, answer;
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			answer = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				// 1 - N극 / 2 - S극
				// 테이블 위 N극 아래가 S극
				for (int j = 0; j <N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			boolean n;
			for (int i = 0; i < N; i++) {
				n = false;
				for (int j = 0; j < N; j++) {
					if(!n && map[j][i] == 1) n = true;
					else if(n && map[j][i] == 2) {
						answer++;
						n=false;
					}
				}
			}
			System.out.println("#"+testCase+" "+answer);
		}

	}

}
