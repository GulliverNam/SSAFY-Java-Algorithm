package com.ssafy.permutation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 중복 순열(nΠr)
 * n의 r제곱개의 순열
 * @author: NamGiwon
 */

public class PermutationNPIR {
	static int n;	// n개의 데이터로 순열 만들기
	static int r;	// r개의 순열
	static int[] numbers;
	static int testCase;
	
	
	/**
	 * 순열을 만들어주는 함수
	 * @param cnt 배열번호
	 */
	public static void permutation(int cnt) {
		if(cnt == r) {
			testCase++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i = 1; i <= n; i++) {
			numbers[cnt] = i;
			permutation(cnt+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		numbers = new int[r];
		permutation(0);
		System.out.printf("%dㅠ%d 중복순열이 생성된 횟수: %d", n, r, testCase);
		sc.close();
	}

}
