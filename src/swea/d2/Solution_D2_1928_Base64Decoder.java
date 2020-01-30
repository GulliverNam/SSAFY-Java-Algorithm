package swea.d2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D2_1928_Base64Decoder {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d2/Solution_D2_1928_Base64Decoder.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		String str;
		int decoding[];
		for (int testCase = 1; testCase <= T; testCase++) {
			str = sc.next();
			decoding = new int[str.length()];
			int ch;
			for (int i = 0; i < str.length(); i++) {
				ch = str.charAt(i);
				if(ch >= 'A' && ch <= 'Z')
					decoding[i] = ch-65;
				else if(ch >= 'a' && ch <= 'z')
					decoding[i] = ch-71;
				else if(ch >= '0' && ch <= '9')
					decoding[i] = ch+4;
				else if(ch == '+')
					decoding[i] = ch+19;
				else
					decoding[i] = ch+16;
			}
			System.out.print("#"+testCase+" ");
			int ch1, ch2, ch3;
			for (int i = 0; i < decoding.length-3; i = i+4) {
				ch1 = (decoding[i]<<2) + (decoding[i+1]>>4);
				decoding[i+1] = decoding[i+1] & 15;
				ch2 = (decoding[i+1]<<4) + (decoding[i+2]>>2);
				decoding[i+2] = decoding[i+2] & 3;
				ch3 = (decoding[i+2]<<6) + (decoding[i+3]);
				System.out.printf("%c%c%c",(char)ch1,(char)ch2,(char)ch3);
			}
			System.out.println();
		}
		sc.close();
	}

}