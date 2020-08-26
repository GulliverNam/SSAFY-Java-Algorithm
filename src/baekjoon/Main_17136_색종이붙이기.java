package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17136_색종이붙이기 {

	static boolean paper[][] = new boolean [10][10];
	static int answer = Integer.MAX_VALUE;
	static int remain[] = {0,5,5,5,5,5};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean exist = false;
		int start[] = new int[2];
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < 10; j++) {
				if(st.nextToken().charAt(0) == '1') {
					paper[i][j] = true;
					if(!exist) {
						exist = true;
						start[0] = i;
						start[1] = j;
					}
				}
			}
		}
		if(exist) {
			coverPaper(start[0], start[1], 0);
			System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
		}
		else
			System.out.println(0);
	}

	private static void coverPaper(int r, int c, int cnt) {
		if(cnt >= answer)
			return;
		if(r == 10) {
			if(isCovered())
				answer = Math.min(answer, cnt);
			return;
		}
		if(paper[r][c]) {
			for (int i = 5; i >= 1; i--) {
				if(remain[i] > 0 && check(r, c, i)) {
					cover(r, c, i);
					remain[i]--;
					if(c+i > 9)
						coverPaper(r+1, 0, cnt+1);
					else
						coverPaper(r, c+i, cnt+1);
					remain[i]++;
					recover(r, c, i);
				}
			}
		} else {
			if(c+1 > 9)
				coverPaper(r+1, 0, cnt);
			else
				coverPaper(r, c+1, cnt);
		}
		
	}

	private static boolean isCovered() {
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				if(paper[i][j])
					return false;
		return true;
	}

	private static void recover(int r, int c, int n) {
		for (int i = r; i < r+n; i++) {
			for (int j = c; j < c+n; j++) {
				paper[i][j] = true;
			}
		}
	}

	private static void cover(int r, int c, int n) {
		for (int i = r; i < r+n; i++) {
			for (int j = c; j < c+n; j++) {
				paper[i][j] = false;
			}
		}
		
	}

	private static boolean check(int r, int c, int n) {
		if(r+n > 10 || c+n > 10)
			return false;
		for (int i = r; i < r+n; i++) {
			for (int j = c; j < c+n; j++) {
				if(!paper[i][j])
					return false;
			}
		}
		return true;
	}

}
