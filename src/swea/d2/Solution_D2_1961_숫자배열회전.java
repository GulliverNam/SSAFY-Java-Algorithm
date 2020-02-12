package swea.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1961_숫자배열회전 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d2/Solution_D2_1961_숫자배열회전.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		int N, arr[][];
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine().trim());
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < N; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			System.out.println("#"+test_case);
			for (int i = 0; i < N; i++) {
				for (int j = N-1; j > -1; j--) {
					System.out.print(arr[j][i]);
				}
				System.out.print(" ");
				for (int j = N-1; j > -1; j--) {
					System.out.print(arr[N-i-1][j]);
				}
				System.out.print(" ");
				for (int j = N-1; j > -1; j--) {
					System.out.print(arr[N-j-1][N-i-1]);
				}
				System.out.println();
				
			}
		}
	}

}
