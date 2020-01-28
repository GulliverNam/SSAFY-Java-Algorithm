package com.ssafy.permutation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 순열(nPn)
 * nPn개의 순열
 * @author: NamGiwon
 */

public class PermutationNPN {
	static int n;	// n개의 데이터로 순열 만들기
	static int[] numbers;
	static int testCase;
	static boolean[] check;
	
	/**
	 * 순열을 만들어주는 함수
	 * @param cnt 배열번호
	 */
	public static void permutation(int cnt) {
		if(cnt == n) {
			testCase++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i = 1; i <= n; i++) {
			if(!check[i]) {
				check[i] = true;
				numbers[cnt] = i;
				permutation(cnt+1);
				check[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		numbers = new int[n];
		check = new boolean[n+1];
		permutation(0);
		System.out.printf("%dP%d 순열이 생성된 횟수: %d", n, n, testCase);
		sc.close();
	}

}
