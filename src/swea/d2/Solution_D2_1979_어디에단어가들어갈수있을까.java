package swea.d2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D2_1979_어디에단어가들어갈수있을까 {
	
	public static int N;
	public static int K;
	public static int answer;
	public static int puzzle[][];
	
	public static void countAnswer(boolean horizon) {
		int count, value;
		for (int i = 0; i < N; i++) {
			count = 0;
			for (int j = 0; j < N; j++) {
				if(horizon) value = puzzle[i][j];
				else value = puzzle[j][i];
				if(value == 1) count++;
				else {
					if(count == K) answer++;
					count = 0;
				}
			}
			if(count == K) answer++;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d2/Solution_D2_1979_어디에단어가들어갈수있을까.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			K = sc.nextInt();
			answer = 0;
			puzzle = new int[N][N];
			
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					puzzle[i][j] = sc.nextInt();
			countAnswer(true);
			countAnswer(false);
			System.out.println("#"+test_case+" "+answer);
		}
		sc.close();
	}
		

}
