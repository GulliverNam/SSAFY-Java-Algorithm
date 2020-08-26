package com.ssafy.subset;

/**
 * 
 * 완전탐색
 * @author NamGiwon
 *
 */

public class Subset1 {
	
	static String[] data = {"a","b","c","d"};
	public static void printSubset(int[] subset) {
		int k =0;
		System.out.print("[");
		for (int s : subset) {
			if(s!=0) {
				System.out.print(data[k++]+" ");
			}
		}
		System.out.println("]");
	}
	public static void main(String[] args) {
		int[] subset = new int[data.length];
		
		// O(2^n)
		// 현재 코드로 작성시 n이 늘어날때마다 for문이 생겨야함.
		for (int i = 0; i < 2; i++) {
			subset[0] = i;
			for (int j = 0; j < 2; j++) {
				subset[1] = j;
				for (int k = 0; k < 2; k++) {
					subset[2] = k;
					for (int l = 0; l < 2; l++) {
						subset[3] = l;
						printSubset(subset);
					}
				}
			}
		}
		
		// -> bit 연산을 이용
		int a = -9;
		System.out.println(a>>1);
		System.out.println(a>>>1);
		
	}
	
}
