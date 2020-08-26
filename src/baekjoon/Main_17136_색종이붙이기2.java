package baekjoon;

import java.io.*;
import java.util.*;

public class Main_17136_색종이붙이기2 {

	static int[][] paper;
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		paper = new int[10][10];
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < 10; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		action(0, 0, new int[] {0,5,5,5,5,5}, 0);
		System.out.println(answer == Integer.MAX_VALUE ? -1:answer);
	}

	private static void action(int r, int c, int[] count, int numPaper) {
		if(answer <= numPaper)
			return;
		if(r > 9) {
			if(isFinish())
				answer = Math.min(answer, numPaper);
			return;
		}
		if(c < 10) {
			if(paper[r][c] == 1) {
				for (int k = 5; k > 0; k--) {
					if(r+k <= 10 && c+k <= 10 && count[k] > 0 && check(r, c, k)) {
						count[k]--;
						cover(r,c,k);
						action(r, c+k, count, numPaper+1);
						uncover(r,c,k);
						count[k]++;
					}
				}
			} else {
				action(r, c+1, count, numPaper);
			}
		} else {
			action(r+1, 0, count, numPaper);
		}
	}

	private static boolean isFinish() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(paper[i][j] == 1)
					return false;
			}
		}
		return true;
	}

	private static void uncover(int r, int c, int k) {
		for (int i = r; i < r+k; i++) {
			for (int j = c; j < c+k; j++) {
				paper[i][j] = 1;
			}
		}
	}

	private static void cover(int r, int c, int k) {
		for (int i = r; i < r+k; i++) {
			for (int j = c; j < c+k; j++) {
				paper[i][j] = 0;
			}
		}
	}

	private static boolean check(int r, int c, int k) {
		for (int i = r; i < r+k; i++) {
			for (int j = c; j < c+k; j++) {
				if(paper[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	
}
