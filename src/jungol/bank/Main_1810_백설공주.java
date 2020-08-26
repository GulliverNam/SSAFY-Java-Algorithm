package jungol.bank;

import java.util.Scanner;

public class Main_1810_백설공주 {
	
	static int n = 9, r = 7, target = 100;
	static int[] nums, family;
	
	public static void solution(int cnt, int start, int sum) {
		if(cnt == r) {
			if(sum == target)
				for (int i = 0; i < r; i++)
					System.out.println(family[i]);
			return;
		}
		for(int i = start; i < n; i++) {
			family[cnt] = nums[i];
			solution(cnt+1, i+1, sum+family[cnt]);
		}
	}
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner("7 8 10 13 15 19 20 23 25");
		Scanner sc = new Scanner("8 6 5 1 37 30 28 22 36");
		nums = new int[n];
		family = new int[r];
		for (int i = 0; i < n; i++)
			nums[i] = sc.nextInt();
		solution(0, 0, 0);
		sc.close();
	}

}
