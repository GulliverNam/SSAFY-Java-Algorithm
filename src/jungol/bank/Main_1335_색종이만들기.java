package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1335_색종이만들기 {

	static int N, paper[][], white, blue;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/bank/Main_1335_색종이만들기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dividePaper(0, N-1, 0, N-1);
		System.out.println(white);
		System.out.println(blue);
	}
	private static void dividePaper(int sr, int er, int sc, int ec) {
		int num = check(sr,er,sc,ec);
		switch(num) {
			case -1:
				int midr = (sr+er) >> 1;
				int midc = (sc+ec) >> 1;
				dividePaper(sr, midr, sc, midc);
				dividePaper(sr, midr, midc+1, ec);
				dividePaper(midr+1, er, sc, midc);
				dividePaper(midr+1, er, midc+1, ec);
				break;
			case 1:
				blue++;
				break;
			case 0:
				white++;
				break;
		} 
	}
	private static int check(int sr, int er, int sc, int ec) {
		int num = paper[sr][sc];
		for (int i = sr; i <= er; i++) {
			for (int j = sc; j <= ec; j++) {
				if(paper[i][j] != num)
					return -1;
			}
		}
		return num;
	}
	
}
