package com.ssafy.permutation;

import java.util.Arrays;

public class NextPermutation {

	static int[] p = {0,0,0,0,0,0,0,0,0,0,1,1,1,1,1};
	
	public static void main(String[] args) {
		int size = p.length-1;
		do {
			System.out.println(Arrays.toString(p));
		}while(np(size));

	}

	private static boolean np(int size) {
		int i = size;
		// 교차점을 찾음
		while(i > 0 && p[i-1] >= p[i]) --i;
		// 교차점을 찾는데 실패 -> 더 이상 다음 permutation이 없음
		if(i == 0) return false;
		
		// 교차할 데이터 찾기
		int j = size;
		while(p[i-1] >= p[j]) --j;
		
		// swap
		int temp = p[i-1];
		p[i-1] = p[j];
		p[j] = temp;
		
		j = size;
		while(i < j) {
			temp = p[i];
			p[i] = p[j];
			p[j] = temp;
			i++;
			--j;
		}
		return true;
	}

}
