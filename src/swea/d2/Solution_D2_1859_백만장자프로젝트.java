package swea.d2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D2_1859_백만장자프로젝트 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d2/Solution_D2_1859_백만장자프로젝트.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int length;
		long answer, max;
		String prices[];
		for(int test_case = 1; test_case <= T; test_case++) {
			sc.nextInt();
			sc.nextLine();
			prices = sc.nextLine().split(" ");
			length = prices.length;
			answer = 0;
			max = 0;
			int num;
			long benefit = 0;
			for (int i = length-1; i > -1; i--) {
				num = Integer.parseInt(prices[i]);
				if(max <= num) {
					answer += benefit;
					max = num;
					benefit = 0;
				} else
					benefit += (max - num);
			}
			answer += benefit;
			System.out.println("#"+test_case+" "+answer);	
		}
		sc.close();

	}

}
