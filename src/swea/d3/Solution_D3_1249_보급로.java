package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_1249_보급로 {

	static int Map[][], N;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_1249_보급로.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine().trim());
		String str;
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(in.readLine().trim());
			Map = new int[N][N];
			for (int i = 0; i < N; i++) {
				str = in.readLine();
				for (int j = 0; j < N; j++) {
					Map[i][j] = (int)(str.charAt(j) - 48);
				}
			}
			
			
			
			System.out.println("#"+testCase);
		}
		
	}

}
