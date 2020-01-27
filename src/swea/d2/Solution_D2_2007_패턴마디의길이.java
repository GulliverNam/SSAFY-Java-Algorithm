package swea.d2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D2_2007_패턴마디의길이 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d2/Solution_D2_2007_패턴마디의길이.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String str = sc.next();
			int answer = 0;
			String prevStr;
			boolean check = false;
			for (int i = 1; i <= 10; i++) {
				prevStr = str.substring(i, i+i);
				for (int j = 1; j < (int)(str.length() / i); j++) {
					if(!prevStr.equals(str.substring(i*j, i*j + i))) break;
					if(j == (int)(str.length() / i) - 1) check = true;
				}
				if(check) {
					answer = i;
					break;
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
		
		sc.close();
		
	}

}
