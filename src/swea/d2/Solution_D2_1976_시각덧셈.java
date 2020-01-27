package swea.d2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D2_1976_시각덧셈 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d2/Solution_D2_1976_시각덧셈.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int h1, m1, h2, m2;
		int h, m;
		for (int test_case = 1; test_case <= T; test_case++) {
			h1 = sc.nextInt();
			m1 = sc.nextInt();
			h2 = sc.nextInt();
			m2 = sc.nextInt();
			m = (m1 + m2) % 60;
			h = h1 + h2 + (m1 + m2) / 60;
			h = h1 + h2 > 12 ? h % 13 + 1: h;
			System.out.println("#"+test_case+" "+h+" "+m);
		}
		
		sc.close();

	}

}
