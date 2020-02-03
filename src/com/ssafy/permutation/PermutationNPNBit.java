package com.ssafy.permutation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 순열(nPn)
 * nPn개의 순열
 * @author: NamGiwon
 */

public class PermutationNPNBit {
	static int n;	// n개의 데이터로 순열 만들기
	static int[] numbers;
	static int testCase;
	
	/**
	 * 순열을 만들어주는 함수
	 * @param cnt	배열번호
	 * @param flag	중복검사 bit mask
	 */
	public static void permutation(int cnt, int flag) {
		if(cnt == n) {
			testCase++;
//			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i = 1; i <= n; i++) {
			if((flag & 1<<i) == 0) {
				numbers[cnt] = i;
				permutation(cnt+1, flag | 1<<i);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		numbers = new int[n];
		long start = System.currentTimeMillis();
		permutation(0,0);
		long end = System.currentTimeMillis();
		System.out.printf("%dP%d 순열이 생성된 횟수: %d\n", n, n, testCase);
		// 순열 nPn 실행시간
		// - 10P10: 92ms
		// - 11P11: 1006ms
		// -> 11부터 위험
		System.out.println("실행시간: "+(end-start)+"ms");
		sc.close();
	}

}
