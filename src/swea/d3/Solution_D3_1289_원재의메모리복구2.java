package swea.d3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D3_1289_원재의메모리복구2 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_1289_원재의메모리복구.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T;test_case++) {
			String data = sc.next();
			int size = data.length();	//문자열의 길이를 리턴
			StringBuilder nData = new StringBuilder(data);
			
			int cnt = 0;				//변경 count
//			첫 bit가 1로 시작하는 비교
//			endWith(문자열) 지정 문자열로 끝나면 true를 리턴
			if (data.startsWith("1")) cnt++;
			
			//현재 index 문자와 다음 index 문자를 비교
			for (int i = 0; i < size-1; i++) {
				if(data.charAt(i) != data.charAt(i+1)) cnt++;
			}
			
			System.out.println("#"+test_case+" "+cnt);
		}
	}
}
