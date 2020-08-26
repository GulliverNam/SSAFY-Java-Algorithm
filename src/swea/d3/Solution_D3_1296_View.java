package swea.d3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D3_1296_View {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_1296_View.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		int N, answer, building[];
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			building = new int[N];
			for (int i = 0; i < N; i++)
				building[i] = sc.nextInt();
			answer = 0;
			int max, diff;
			for (int i = 2; i < N-2; i++) {
				max = building[i-2];
				max = Math.max(max, building[i-1]);
				max = Math.max(max, building[i+1]);
				max = Math.max(max, building[i+2]);
				diff = building[i] - max;
				answer = diff > 0 ? answer+diff:answer;
			}

			
			System.out.println("#"+testCase+" "+answer);
		}
		
		sc.close();
	}

}
