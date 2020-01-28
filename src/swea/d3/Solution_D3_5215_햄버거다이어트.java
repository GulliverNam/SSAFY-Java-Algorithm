package swea.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_5215_햄버거다이어트 {
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_5215_햄버거다이어트.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N, maxCal, answer, sumCals, sumScores;
		int[] cals, scores;
		for(int test_case = 1; test_case <= T; test_case++){
			N = sc.nextInt();
			maxCal = sc.nextInt();
			cals = new int[N];
			scores = new int[N];
			answer = 0;
			for (int i = 0; i < N; i++) {
				scores[i] = sc.nextInt();
				cals[i] = sc.nextInt();
			}
			
			for (int i = 0, size = 1<<N; i < size; i++) {
				sumCals = 0;
				sumScores = 0;
				for (int j = 0; j < N; j++) {
					if((i & 1<<j) != 0) {
						sumCals += cals[j];
						sumScores += scores[j];
					}
				}
				if(sumCals <= maxCal) answer = Math.max(answer, sumScores);
			}
			System.out.println("#"+test_case+" "+answer);
		}
		sc.close();
	}

}
