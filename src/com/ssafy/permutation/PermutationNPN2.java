package com.ssafy.permutation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 순열(nPn)
 * nPn개의 순열
 * @author: NamGiwon
 */

public class PermutationNPN2 {
	static int n;	// n개의 데이터로 순열 만들기
	static int[] numbers;
	static int testCase;
	static boolean[] selected;
	
	/**
	 * 순열을 만들어주는 함수
	 * @param cnt 배열번호
	 */
	public static void permutation(int cnt) {
		if(cnt == n) {
			testCase++;
//			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i = 1; i <= n; i++) {
			if(!selected[i]) {
				selected[i] = true;
				numbers[cnt] = i;
				permutation(cnt+1);
				selected[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		numbers = new int[n];
		selected = new boolean[n+1];
		long start = System.currentTimeMillis();
		permutation(0);
		long end = System.currentTimeMillis();
		System.out.printf("%dP%d 순열이 생성된 횟수: %d\n", n, n, testCase);
		// 순열 nPn 실행시간
		// - 10P10: 106ms
		// - 11P11: 1243ms
		// -> 11부터 위험
		System.out.println("실행시간: "+(end-start)+"ms");
		sc.close();
	}

}