package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_8958_OX퀴즈 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/Main_8958_OX퀴즈.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		char[] ox;
		int score, seq;
		for (int testCase = 1; testCase <= T; testCase++) {
			ox = br.readLine().trim().toCharArray();
			score = seq = 0;
			for (int i = 0; i < ox.length; i++) {
				if(ox[i] == 'O') {
					seq++;
					score += seq;
				}
				else {
					seq = 0;
				}
			}
			System.out.println(score);
		}
	}

}
