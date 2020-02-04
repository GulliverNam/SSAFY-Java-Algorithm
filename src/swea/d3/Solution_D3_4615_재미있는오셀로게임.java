package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_4615_재미있는오셀로게임 {
	static int N, M, Map[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_4615_재미있는오셀로게임.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			Map = new int[N+1][N+1];
			for (int i = N/2; i <= N/2+1; i++) {
				for (int j = N/2; j <= N/2+1; j++) {
					if((i^j) == 0) Map[i][j] = 2;
					else Map[i][j] = 1;
				}
			}
			int r, c, dol;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				r = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				dol = Integer.parseInt(st.nextToken());
				play(r, c, dol);
			}
			System.out.println("#"+testCase);
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					System.out.print(Map[i][j]+" ");
				}
				System.out.println();
			}
			
		}
	}
	private static void play(int r, int c, int dol) {
		// TODO Auto-generated method stub
		
	}

}
