package com.ssafy.subset;

public class Subset2 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int[] arr = {3, 6, 7, 1, 5, 2, 6, 7, 1, 5, 2, 6, 7, 1, 5, 2};
		int n = arr.length;

		/* 
		   subset의 개수는 2^n개
		   - size = 1<<n; 
		   - O((2^n)^2)
		   - n이 16개 까지는 무난함 -> 2^16 = 약 6.5만개
		   - 중복이 포함됨
		   - n이 20개 까지 0.5 ~ 1초 이내로 처리할 수 있음 -> 2^20 = 약 100만개
		 */
		int[] newArr = new int[n];
		for (int i = 0, size = 1<<n; i < size; i++) {
			for (int j = 0; j < n; j++) {
				if((i & 1<<j) != 0) {
//					newArr = 
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}

}
