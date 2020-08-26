package com.ssafy.subset;

import java.util.Arrays;

public class Subset2 {

	public static void main(String[] args) {
		int[] arr = {3, 6, 7, 1, 5, 2, 6, 7, 1};
		int n = arr.length;

		/* 
		   subset의 개수는 2^n개
		   - size = 1<<n; 
		   - O((2^n)^2)
		   - n이 16개 까지는 무난함 -> 2^16 = 약 6.5만개
		   - 중복이 포함됨
		   - n이 20개 까지 0.5 ~ 1초 이내로 처리할 수 있음 -> 2^20 = 약 100만개
		 */
		int size = 1<<n;
//		int[] select;
		int[] select = new int[n];
		int[][] subsets = new int[size][n];
		
		for (int i = 0; i < size; i++) {
			// 인스턴스를 매번 생성해주는 것이 더 속도가 느림.
//			select = new int[n];
			for (int j = 0; j < n; j++)
				if((i & 1<<j) != 0)
					select[j] = 1;
//			subsets[i] = select; // 레퍼런스이기 때문에 마지막 select값이 저장됨. -> 인스턴스를 매번 생성해주면 이것도 가능(매번 다른 인스턴스가 저장됨) 
			
			/*아래 두 줄을 이용하면 매번 인스턴스를 생성하지 않아도 된다.*/
			subsets[i] = Arrays.copyOf(select, n);
			Arrays.fill(select, 0);
		}
		
		for (int[] is : subsets) {
			System.out.println(Arrays.toString(is));
		}
	}

}
