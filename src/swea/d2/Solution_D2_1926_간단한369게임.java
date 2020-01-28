package swea.d2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D2_1926_간단한369게임 {
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d2/Solution_D2_1926_간단한369게임.txt"));
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int hyphen;
		String s;
		
		for(int i = 1; i <= n; i++) {
			s = Integer.toString(i);
			hyphen = 0;
			for(int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == '3' || s.charAt(j) == '6' || s.charAt(j) == '9')
					hyphen++;
			}
			if(hyphen == 0) System.out.print(i);
			else
				for(int k = 0; k < hyphen; k++) System.out.print("-");
			
			System.out.print(" ");
			
		}
	}
	
}
