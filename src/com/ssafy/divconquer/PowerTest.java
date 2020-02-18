package com.ssafy.divconquer;

import java.math.BigDecimal;
import java.math.BigInteger;

public class PowerTest {

//	public static long powerRec(int x, int n) {
//		if(n > 0)
//			return x*powerRec(x, n-1);
//		return 1;
//	}
	public static long powerRec(long x, long n) {
		long result = x;
		for (int i = 0; i < n-1; i++) {
			result *= x;
		}
		return result;
	}
	
	/**
	 * 분할 정복을 이용한 power 구하는 기능
	 * @param args
	 */
	public static BigInteger dcPower(BigInteger x, int n) {
		if(n == 0) return new BigInteger("1");
		else if(n == 1) return x;
		BigInteger result = dcPower(x, n>>1);
		if(n % 2 == 0)
			return result.multiply(result);
		return result.multiply(result.multiply(x));
	}
	public static void main(String[] args) throws Exception {
//		System.out.println(powerRec(9, 2111111111));
		System.out.println(dcPower(new BigInteger("2"), 3));
	}

}
