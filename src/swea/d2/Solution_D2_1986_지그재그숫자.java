package swea.d2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D2_1986_지그재그숫자 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d2/Solution_D2_1986_지그재그숫자.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N, k, answer;
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			answer = 0;
			k = N / 2;
			answer -= k*(k+1);
			if(N % 2 == 1) k++;
			answer += k*k;
			System.out.println("#"+test_case+" "+answer);
		}
		sc.close();
	}

}
