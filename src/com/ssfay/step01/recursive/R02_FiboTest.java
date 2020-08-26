package com.ssfay.step01.recursive;

import java.util.Scanner;

public class R02_FiboTest {
	
	static long[] call1, call2, memo;
	static long totalCnt1, totalCnt2;
	
	private static long fibo(int n) {
		++call1[n];
		++totalCnt1;
		if(n<=1) return n;
		return fibo(n-1) + fibo(n-2);
	}
	
	private static long fibo2(int n) {
		++call2[n];
		++totalCnt2;
		if(memo[n] != 0) return memo[n];
		if(n<=1) return n;
		return memo[n] = fibo2(n-1) + fibo2(n-2);
	}
	
	
//	private static long fibo3(int n) {
//		long f[] = new long[n+1];
//		f[1] = 1;
//		f[2] = 1;
//		for (int i = 3; i <= n; i++) {
//			f[i] = f[i-2] + f[i-1];
//		}
//		return f[n];
//	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		call1 = new long[n+1];
		call2 = new long[n+1];
		memo = new long[n+1];
		System.out.println(fibo2(n));
		for (int i = 1; i <= n; i++) {
			System.out.println("fibo2("+i+") : "+call2[i]);
		}
		System.out.println("fibo2 call count : "+totalCnt2);
		System.out.println(fibo(n));
		for (int i = 1; i <= n; i++) {
			System.out.println("fibo("+i+") : "+call1[i]);
		}
		System.out.println("fibo call count : "+totalCnt1);
		sc.close();
		
	}

}
