package swea.d2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D2_1961_숫자배열회전 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d2/Solution_D2_1961_숫자배열회전.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int N, arr[][];
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			arr = new int[N][N];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					arr[i][j] = sc.nextInt();
					
		}
		
		sc.close();

	}

}
