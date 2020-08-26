package swea.d4;

import java.util.Scanner;

public class Solution_D4_4796_의석이의우뚝선산 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int nums[] = new int[N];
			for (int i = 0; i < N; i++)
				nums[i] = sc.nextInt();
			int prev = nums[0];
			int answer = 0;
			boolean up = true;
			int left = 0, right = 0;
			for (int i = 1; i < N; i++) {
				int next = nums[i];
				if(up) {
					if(prev < next)
						left++;
					else {
						up = false;
						right++;
					}
				} else {
					if(prev > next)
						right++;
					else {
						answer += left*right;
						up = true;
						left = 1;
						right = 0;
					}
				}
				if(i == N-1)
					answer += left*right;
				prev = next;
			}
			
			System.out.println("#"+tc+" "+answer);
		}
		sc.close();
	}

}
