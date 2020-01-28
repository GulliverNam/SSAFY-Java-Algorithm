package com.ssafy.recursive;

public class RecursiveCallFactorial {

	public static int recurFac(int n) {
		if(n == 2) return 2;
		return n * recurFac(n-1);
	}

	public static void main(String[] args) {
		int n = 7;
		int fac = 1;
		for (int i = 2; i <= n; i++) {
			System.out.println(fac);
			fac *= i;
		}
		System.out.println(fac);
		System.out.println(recurFac(n));
	}

}
