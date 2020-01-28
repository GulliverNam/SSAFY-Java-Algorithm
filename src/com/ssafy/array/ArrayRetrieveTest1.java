package com.ssafy.array;

public class ArrayRetrieveTest1 {

	public static void main(String[] args) {
		int[][] data = {{1,2,3},
						{4,5,6},
						{7,8,9}};
		
		int n = data.length;
		
		//행우선 접근
		for (int i = 0; i < n; i++) {		//행반복
			for (int j = 0; j < n; j++) {	//열반복
				System.out.print(data[i][j]+" ");
			}
			System.out.println();
		}
	}

}
