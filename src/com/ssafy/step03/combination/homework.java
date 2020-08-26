package com.ssafy.step03.combination;

import java.util.Arrays;
import java.util.Scanner;

public class homework {

	static int R, M, nums[];
	static boolean selected[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		M = sc.nextInt();
		nums = new int[R];
		selected = new boolean[6];
		switch(M) {
		case 1:case1(0); break;
		case 2:case2(0, 1); break;
		case 3:case3(0); break;
		case 4:case4(0, 1); break;
		}
		sc.close();
	}
	private static void case4(int cnt, int start) {
		if(cnt == R) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = start; i <= 6; i++) {
			nums[cnt] = i;
			case4(cnt+1, i+1);
		}
	}
	private static void case3(int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = 1; i <= 6; i++) {
			if(!selected[i-1]) {
				selected[i-1] = true;
				nums[cnt] = i;
				case3(cnt+1);
				selected[i-1] = false;
			}
		}
		
	}
	private static void case2(int cnt, int start) {
		if(cnt == R) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = start; i <= 6; i++) {
			nums[cnt] = i;
			case2(cnt+1, i);
		}
	}
	private static void case1(int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = 1; i <= 6; i++) {
			nums[cnt] = i;
			case1(cnt+1);
		}
	}
}
