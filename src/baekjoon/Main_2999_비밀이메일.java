package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_2999_비밀이메일 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/Main_2999_비밀이메일.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().trim().toCharArray();
		int N = str.length;
		int R = 0, C = 0;
		for (int i = 1; i <= N/2; i++) {
			if(N % i == 0) {
				if(N / i < i)
					break;
				else {
					C = N/i;
					R = i;
				}
			}
		}
		System.out.println(R+" "+C);
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.println((j*C+i));
//				System.out.print(str[j*C+i]);
			}
		}
		System.out.println();
	}

}
