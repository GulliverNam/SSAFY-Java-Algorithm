package swea.d2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Solution_D2_1983_조교의성적매기기 {
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d2/Solution_D2_1983_조교의성적매기기.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int N, K;
		double key;
		HashMap<Double, Double> grade;
		Double total[];
		String answers[] = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			K = sc.nextInt();
			total = new Double[N];
			grade = new HashMap<Double, Double>();
			for (int i = 0; i < N; i++)
				total[i] = sc.nextInt()*0.35 + sc.nextInt()*0.45 + sc.nextInt() * 0.2;
			key = total[K-1];
			Arrays.sort(total, Collections.reverseOrder());
			for (int i = 0; i < N; i++) {
				grade.put(total[i], (double)i);
			}
			
			System.out.println("#"+test_case+" "+answers[(int)(grade.get(key) / N * 10)]);
			
		}
		sc.close();

	}

}
