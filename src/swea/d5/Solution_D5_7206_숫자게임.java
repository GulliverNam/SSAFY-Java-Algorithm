package swea.d5;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D5_7206_숫자게임 {
	
	static int turn;
	static int[] memo = new int[100000];
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Arrays.fill(memo, -1);
		for (int i = 1; i < 100000; i++) {
			if(i < 10) {
				memo[i] = 0;
			} else if(i < 25) {
				memo[i] = 1;
			}
			else {
				turn = 0;
				divideNum(String.valueOf(i),0);
				memo[i] = turn;
			}
		}
		for (int tc = 1; tc <= T; tc++) {
			int num = sc.nextInt();
			System.out.println("#"+tc+" "+memo[num]);
		}
		sc.close();
	}

	private static void divideNum(String num, int cnt) {
		int n = Integer.parseInt(num);
		if(memo[n] == -1) {
			for (int i = 1, length = num.length(); i < length; i++) {
				subSet(1, 0, cnt+1, i, num, new String[i+1]);
			}
		} else {
			turn = Math.max(turn, memo[n]+cnt);
		}
	}
		

	private static void subSet(int start, int idx, int cnt, int divide, String num, String[] selected) {
		if(idx == divide) {
			selected[idx] = num.substring(start-1);
			int value = 1;
			for (String s : selected) {
				value *= Integer.parseInt(s);
				if(value == 0) break;
			}
			if(value >= 10) {
				divideNum(String.valueOf(value), cnt);
			} else {
				turn = Math.max(turn, cnt);
			}
			return;
		}
		for (int i = start, length = num.length(); i < length; i++) {
			selected[idx] = num.substring(start-1,i);
			subSet(i+1, idx+1, cnt, divide, num, selected);
		}
	}

}
