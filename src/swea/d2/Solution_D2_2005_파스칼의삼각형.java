package swea.d2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D2_2005_파스칼의삼각형 {

	public static void drawTriangle(int N) {
		int arr[][] = new int[N][N];
		arr[0][0] = 1;
		for(int i = 1; i < N; i++) {
			for (int j = 0; j < i+1; j++) {
				if(j == 0 || j == i) arr[i][j] = 1;
				else {
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < i + 1; j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d2/Solution_D2_2005_파스칼의삼각형.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int N;
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			System.out.println("#"+test_case);
			drawTriangle(N);
		}
		
		sc.close();

	}

}
