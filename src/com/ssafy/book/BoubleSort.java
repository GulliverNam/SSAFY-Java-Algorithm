package com.ssafy.book;

import java.util.Arrays;

public class BoubleSort {

	public static void main(String[] args) {
		int arr[] = {1,45,2534,64,231,24,416,4,34,3,43};
		int length = arr.length;
		
		for (int i = 0; i < length-1; i++) {
			for (int j = 0; j < length-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));

	}

}
