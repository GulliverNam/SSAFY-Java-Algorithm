package com.ssafy.sort;

import java.util.Arrays;

public class QuickSortTest {

	public static void main(String[] args) {
		int data[] = {69, 10, 30, 2, 16, 8, 31, 22};
		quickSort(data, 0, data.length-1);
	}

	private static void quickSort(int[] data, int begin, int end) {
		// begin이 end와 같거나 커지면 더이상 원한느 데이터(작은값, 큰값)을 찾을 수 없는 상황
		if(begin < end) {
			System.out.println(Arrays.toString(data));
			int p = begin;
			int left = begin+1, right = end, temp;
			do {
				// 왼쪽부터 피봇보다 큰 값을 찾는다.
				// 피봇보다 값이 작으면 진행, 크면 반복 중단
				while(left < end && data[left] < data[p]) left++;
				
				// 오른쪽부터 피봇값 보다 작은 값을 찾는다.
				// 피봇보다 값이 크면 패스, 작으면 반복 중단
				while(right > p && data[right] >= data[p]) right--;
				
				// 피봇보다 작으면 왼쪽, 크면 오른쪽으로 이동
				if(left < right) {
					temp = data[left];
					data[left] = data[right];
					data[right] = temp;
				}
			}while(left < right);
			
			// 피봇보다 작은값, 큰값을 발견하지 못하면 피봇을 이동해 피봇 고정
			temp = data[p];
			data[p] = data[right];
			data[right] = temp;
			
			// 피봇부터 왼쪽 정렬
			quickSort(data, begin, right-1); 
			
			// 피봇부터 오른쪽 정렬
			quickSort(data, right+1, end);
		}
		
	}

}
