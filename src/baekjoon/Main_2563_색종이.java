package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_색종이 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/Main_2563_색종이.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int paper[][] = new int[100][100];
		int N = Integer.parseInt(br.readLine().trim());
		int c, r;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			c = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			for (int j = r-1; j < r+9; j++) {
				for (int k = c-1; k < c+9; k++) {
					paper[j][k] = 1;
				}
			}
		}
		int answer = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(paper[i][j] == 1)
					answer++;
			}
		}
		System.out.println(answer);
	}

}
