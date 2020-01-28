package com.ssafy.array;

public class ArrayRetrieveTest2 {

	public static void main(String[] args) {
		int[][] data = {{1,2,3},
						{4,5,6},
						{7,8,9}};
		
		int n = data.length;
		
		//열우선 접근
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(data[j][i]+" ");
			}
			System.out.println();
		}
	}

}
