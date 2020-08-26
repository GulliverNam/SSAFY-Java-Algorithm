package swea.d5;

import java.util.HashMap;
import java.util.Scanner;

public class Solution_D5_7206_숫자게임2 {
	
	static int turn;
	static HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int num = sc.nextInt();
			System.out.println("#"+tc+" "+game(num));
		}
		sc.close();
	}

	public static int game(int n) {
		if(n < 10) {
			return 0;
		}
		int max = 0;
		String s = ""+n;
		int length = s.length() - 1;
		
		for (int i = 1, size = 1<<length; i < size; i++) {
			int num = s.charAt(0) - '0';
			int mul = 1;
			for (int j = 0; j < length; j++) {
				if((i & 1<<j) == 0) { // 쪼개는 위치가 아님
					num = num*10 + s.charAt(j+1) - '0';
				} else {
					mul *= num;
					num = s.charAt(j+1)-'0';
				}
			}
			mul *= num;
			int cnt = 0;
			if(memo.containsKey(mul)) {
				cnt = memo.get(mul);
			} else {
				cnt = game(mul);
				memo.put(mul, cnt);
			}
			max = Math.max(max, cnt);
		}
		return max+1;
	}
}
