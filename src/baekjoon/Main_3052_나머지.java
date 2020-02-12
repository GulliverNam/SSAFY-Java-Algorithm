package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_3052_나머지 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/Main_3052_나머지.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean count[] = new boolean[42];
		int num, answer = 0;
		for (int i = 0; i < 10; i++) {
			num = Integer.parseInt(br.readLine().trim()) % 42;
			if(!count[num]) {
				count[num] = true;
				answer++;
			}
		}
		System.out.println(answer);

	}

}
