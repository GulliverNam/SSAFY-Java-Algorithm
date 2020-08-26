package com.ssafy.array;

public class ArrayRetrieveTest5 {

	public static void main(String[] args) {
		int[][] data = {{1,2,3,4},
						{5,6,7,8},
						{9,10,11,12},
						{13,14,15,16}};
		
		int n = data.length;
		
		//지그재그 접근
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(data[i][j+(n-1 - 2*j)*(i%2)]+" ");
			System.out.println();
		}
	}

}
