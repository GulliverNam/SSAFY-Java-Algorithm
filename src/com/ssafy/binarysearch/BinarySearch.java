package com.ssafy.binarysearch;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {2,4,6,8,10,12,14,16,19,21};
		int left = 0;
		int right = 9;
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		while(left <= right) {
			int mid = (left + right) / 2;
			if(arr[mid] < target) {
				left = mid+1;
			} else if (arr[mid] > target) {
				right = mid-1;
			} else {
				System.out.println("answer!! "+mid);
				break;
			}
		}
		sc.close();
	}

}
