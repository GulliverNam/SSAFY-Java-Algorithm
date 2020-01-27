package swea.d2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D2_2001_파리퇴치 {
	public static int arr[][];
	public static int N, M;
	public static int answer;
	
	public static void findMax() {
		for (int i = 0; i <= N-M; i++)
			for (int j = 0; j <= N-M; j++)
				answer = Math.max(answer, sum(i,j));
	}
	
	public static int sum(int x, int y) {
		int result = 0;
		for (int i = x; i < x+M; i++) {
			for (int j = y; j < y+M; j++) {
				result += arr[i][j];
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d2/Solution_D2_2001_파리퇴치.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N][N];
			answer = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					arr[i][j] = sc.nextInt();
			}
			
			findMax();
			System.out.println("#" + test_case + " " + answer);
		}
		sc.close();
	}

}
