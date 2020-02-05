package com.ssafy.subset;

public class Test {

	public static void main(String[] args) {
		boolean check[] = new boolean[8];
		int nums[] = {4,3,4,6};
		
		for (int i = 0; i < 3; i++) {
			for (int j = i+1; j < 4; j++) {
				if(!check[i]) {
					System.out.println(nums[i]+" "+nums[j]);
				}
			}
			check[i] = true;
		}
	}

}
