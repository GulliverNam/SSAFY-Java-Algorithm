package swea.d2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D2_1989_초심자의회문검사 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d2/Solution_D2_1989_초심자의회문검사.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String str;
		int length,index, answer;
		for(int test_case = 1; test_case <= T; test_case++) {
			str = sc.next();
			length = str.length();
			index = length / 2;
			answer = 1;
			for (int i = 0; i < index; i++) {
				if(str.charAt(i) != str.charAt(length-i-1)) {
					answer = 0;
					break;
				}
			}
			System.out.println("#"+test_case+" "+answer);
		}
		sc.close();

	}

}
