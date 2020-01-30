package swea.d3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D3_1209_Sum {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_1209_Sum.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		int arr[][];
		int max;
		for (int testCase = 1; testCase <= T; testCase++) {
			sc.nextInt();
			arr = new int[100][100];
			max = 0;
			int line, diagonal1 = 0, diagonal2 = 0;
			for (int i = 0; i < 100; i++) {
				line = 0;
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
					if(i == j) diagonal1 += arr[i][j];
					if(i == 99-j) diagonal2 += arr[i][j];
					line += arr[i][j];
				}
				max = Math.max(max, line);
			}
			max = Math.max(max, diagonal1);
			max = Math.max(max, diagonal2);
			
			for (int i = 0; i < 100; i++) {
				line = 0;
				for (int j = 0; j < 100; j++)
					line += arr[j][i];
				max = Math.max(max, line);
			}
			
			System.out.println("#"+testCase+" "+max);
		}
		
		sc.close();
	}

}
