package com.ssafy.recursive;

public class RecursiveCallSum {

	// 10+9+8+...+1
	static int cnt = 0;
	public static int recurSum(int n) {
		cnt++;
		if(n == 1) return 1;
		return recurSum(n-1) + n;
	}
	
	public static void main(String[] args) {
		int sum = 0;
		int n = 21242;
		System.out.println(n*(n+1)/2);
		// 1+2+3+...+10
		for (int i = 1; i <= n; i++) sum += i;
		System.out.println(sum);
		System.out.println(recurSum(n));
		System.out.println("cnt: "+cnt);
	}

}
