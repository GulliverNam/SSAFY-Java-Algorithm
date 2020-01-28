package com.ssafy.combination;

public class CombinationTest2 {

	public static void main(String[] args) {
		int[] arr = {3, 6, 7, 1, 5};
		int n = arr.length;
		int r = 3;
		int[] combi = new int[n];
		/* 
		   subset에서 r개 짜리만 따로 추출하면 조합이 된다.
		 */
		int k;
		for (int i = 0, size = 1<<n; i < size; i++) {
			k = 0;
			for (int j = 0; j < n; j++) {
				if((i & 1<<j) != 0) {
					combi[k++] = j;
				}
			}
			if(k == r) {
				print(arr, combi, r);
			}
		}
	}

	private static void print(int[] arr, int[] combi, int r) {
		for (int i = 0; i < r; i++)
			System.out.print(arr[combi[i]] + " ");
		System.out.println();
	}

}
