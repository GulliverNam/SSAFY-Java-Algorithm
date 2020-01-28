package com.ssafy.recursive;

public class RecursiveCallFibo {

	public static int fibo1(int n) {
		int sum = 0;
		int oldSu = 0;
		int su = 1;
		int newSu = 0;
		for (int i = 1; i <= n; i++) {
			System.out.print(su+" ");
			sum += su;
			newSu = oldSu + su;
			oldSu = su;
			su = newSu;
		}
		return sum;
	}
	public static int fibo2(int n) {
		if(n == 1 || n == 2) return 1;
		return fibo2(n-1) + fibo2(n-2);
	}
	
	/**
	 * fibo3 - n번째까지의 피보나치 수열과 합을 구하는 method
	 * @param cnt	n번째
	 * @param prev	n-1
	 * @param next	n-2
	 * @return 이전 두 수의 합
	 */
	public static int fibo3(int cnt, int prev, int next) {
		if(cnt == 1) {
			System.out.print(next + " ");
			return next;
		}
		System.out.print(next + " ");
		return next + (fibo3(cnt-1, next, prev+next));
	}
	
	public static void main(String[] args) {
		int n = 7;
		System.out.println("합: " + fibo1(n));
		System.out.println("합: " + fibo2(n));
		System.out.println("합: " + fibo3(n, 0, 1));
	}

}
