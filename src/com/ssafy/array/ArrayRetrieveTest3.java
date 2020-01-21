package com.ssafy.array;

public class ArrayRetrieveTest3 {

	public static void main(String[] args) {
		int[][] data = {{1,2,3},
						{4,5,6},
						{7,8,9}};
		
		int n = data.length;
		
		//지그재그 접근
		for (int i = 0; i < n; i++) {
			if(i%2 == 0) {
				for(int j = 0; j < n; j++) {
					System.out.print(data[i][j]+ " ");
				}
			}else{
				for(int j = n-1; j > -1; j--) {
					System.out.print(data[i][j]+" ");
				}
			}
			System.out.println();
		}
	}

}
