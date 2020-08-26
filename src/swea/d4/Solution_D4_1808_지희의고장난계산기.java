package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D4_1808_지희의고장난계산기 {
	static boolean digit[];
	static int X, answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			digit = new boolean[10];
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < 10; i++) {
				if(st.nextToken().charAt(0) == '1')
					digit[i] = true;
			}
			X = Integer.parseInt(br.readLine().trim());
			boolean check = true;
			for (char c : Integer.toString(X).toCharArray()) {
				if(!digit[c-'0'])
					check = false;
			}
			if(check) {
				answer = Integer.toString(X).length()+1;
			} else {
				answer = Integer.MAX_VALUE;
			}
			findMin(X, 0);
			System.out.println("#"+tc+" "+(answer == Integer.MAX_VALUE? -1:answer));
		}
	}
	private static void findMin(int num, int cnt) {
		if(num == 1) return;
		top:
		for (int i = 2; i <= num/2; i++) {
			if(num % i == 0) {
				int length = 0;
				for (char c : Integer.toString(i).toCharArray()) {
					if(!digit[c-'0'])
						continue top;
				}
				length += Integer.toString(i).toCharArray().length + 1;
				for (char c : Integer.toString(num/i).toCharArray()) {
					if(!digit[c-'0']) {
						if(cnt+length < answer)
							findMin(num/i, cnt+length);
						continue top;
					}
				}
				length += Integer.toString(num/i).toCharArray().length + 1;
				answer = Math.min(answer, cnt+length);
			}
		}
	}

}
