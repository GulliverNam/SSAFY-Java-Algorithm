package com.ssafy.search;

import java.util.Arrays;

public class BinarySearchTestAPI {

	public static void main(String[] args) {
		int[] data = {3,1,2,5,6,4,8,7,9};
		
		/**
		 * Arrays.binarySearch(array, value)
		 * 값의 index를 return
		 * array이 정렬되어 있지 않으면 index를 찾지 못함 -> -value return
		 */
		System.out.println(Arrays.binarySearch(data, 10));
		Arrays.sort(data);
		System.out.println(Arrays.toString(data));
		System.out.println(Arrays.binarySearch(data, 10));

	}

}
