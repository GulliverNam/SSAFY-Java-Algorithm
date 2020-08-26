package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1438_색종이 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/bank/Main_1438_색종이.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int paper[][] = new int[100][100];
		int N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		int c, r;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			c = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			for (int a = r-1; a < r+9; a++) {
				for (int b = c-1; b < c+9; b++) {
					paper[a][b] = 1;
				}
			}
		}
		int answer = 0;
		for (int[] p: paper) {
			for (int i : p) {
				if(i == 1) answer++;
			}
		}
		System.out.println(answer);
	}

}
