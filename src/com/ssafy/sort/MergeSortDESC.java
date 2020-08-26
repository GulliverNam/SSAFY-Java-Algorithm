package com.ssafy.sort;

import java.util.Arrays;

/**
 * 분할 정복을 이용한 Merge Sorting
 * 
 * 최악 시간복잡도:	O(nlogn)
 * 평균 시간복잡도:	O(nlogn)
 * 
 */

public class MergeSortDESC {
	// 두 그룹의 데이터를 병합하면서 정렬할 때 사용할 임시 배열
	// : 정렬할 데이터 크기만큼 선언
	static int[] sorted;
	
	public static void main(String[] args) {
		int data[] = {69, 10, 30, 2, 16, 8, 31, 22};
		int size = data.length;
		sorted = new int[size];
		System.out.println("sorting start");
		System.out.println(Arrays.toString(data));
		
		mergeSort(data, 0, size-1);
	}

	private static void mergeSort(int[] data, int start, int end) {
		if(start < end) { // start == end : 원소가 하나 남음
			// 1. 데이터를 반씩 분할 -> 원소가 한개가 될때까지 분할
			int mid = (start + end)>>1;
			mergeSort(data, start, mid);
			mergeSort(data, mid+1, end);
			// 2. 병합
			merge(data, start, mid, end);
		}
	}

	private static void merge(int[] data, int s, int mid, int e) {
		// 임시로 정렬한 데이터를 원래(data[])에 옮길때 s, e값을 사용
		// : s와 e 변수가 변하면 안됨.
		int start = s, end = e, next = mid+1, k = s;
		
		// 두 집합 중에 작은 값들은 임시 배열에 저장
		while(start <= mid && next <= end) {
			if(data[start] >= data[next])
				sorted[k] = data[start++];
			else
				sorted[k] = data[next++];
			k++;
		}
		
		// 임시로 정렬된 sorted배열에 반대편 데이터 옮기기
		if(start > mid) {
			for (int i = next; i <= e; i++, k++)
				sorted[k] = data[i];
		} else {
			for (int i = start; i <= mid; i++, k++)
				sorted[k] = data[i];
		}
		
		// 임시로 정렬된 데이터를 원래 배열에 옮기기
		for (int i = s; i <= e; i++) {
			data[i] = sorted[i];
		}
		System.out.print("merge sorting >> ");
		System.out.println(Arrays.toString(data));
	}

}
