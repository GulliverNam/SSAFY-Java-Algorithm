package com.ssafy.combination;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationTest1 {

	static int n, r, testCase, numbers[];
	
	/**
	 * combination - 조합을 만드는 함수
	 * @param cnt
	 * @param start
	 */
	public static void combination(int cnt, int start) {
		if(cnt == r) {
			testCase++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i = start ; i <= n; i++) {
			numbers[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		testCase = 0;
		numbers = new int[r];
		combination(0, 1);
		System.out.printf("%dC%d의 조합 수: %d\n",n,r,testCase);
		sc.close();
	}

}
