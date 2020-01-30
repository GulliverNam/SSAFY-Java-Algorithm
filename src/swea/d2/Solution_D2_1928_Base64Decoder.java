package swea.d2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D2_1928_Base64Decoder {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d2/Solution_D2_1928_Base64Decoder.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int a = 'A'-65; // 대문자 -65
		int b = 'z'-71; // 소문자 -71
		int c = '0'+9; // 숫자 +4
		int d = '+'+19; // 특수문자 + 19
		System.out.println(a+" "+b+" "+c+" "+d);
		
		String str;
		for (int testCase = 1; testCase <= T; testCase++) {
			str = sc.next();
			int ch;
			for (int i = 0; i < str.length(); i++) {
				ch = str.charAt(i);
				if(ch >= 'A' && ch <= 'Z') {
					
				}
				else if(ch >= 'a' && ch <= 'z') {
					
				}
				else if(ch >= '0' && ch <= '9') {
					
				}
				else {
					
				}
				
			}
		}
		
		
		sc.close();
	}

}
