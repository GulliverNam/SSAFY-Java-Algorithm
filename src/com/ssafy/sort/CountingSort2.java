package com.ssafy.sort;

import java.util.Arrays;

/**
 * CountingSort: 시간복잡도가 O(n)으로 끝나는 유일한 sorting방법
 * - 데이터의 크기가 크면 공간복잡도가 커짐
 * - 정수데이터가 아닐 시 사용할 수 없음
 * @author NamGiwon
 *
 */

public class CountingSort2 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int[] data = {100000000, 0, 4, 1, 3, 1, 2, 4, 1};
//		int[] data = new int[100000001];
//		for (int i = 0; i < 100000001; i++)
//			data[i] = 100000000;
		
		// step1. max값 찾기 및 카운트 배열 생성
		int maxNum = Integer.MIN_VALUE;
		for (int d : data)
			maxNum = Math.max(maxNum, d);
		int[] counts = new int[maxNum+1];
		System.out.println("maxNum:\t"+maxNum);
		
		// step2. 데이터 개수 세기
		for (int d : data)
			counts[d]++;
		
		// step3. 데이터 배열과 count 배열을 이용해 정렬하기
		int temp[] = new int[data.length];
		for (int i = 0, index = 0; i < maxNum+1; i++) {
			for (int j = 0; j < counts[i]; j++) {
				temp[index++] = i;
			}
		}
		System.out.println("sorted array:\t"+Arrays.toString(temp));

		long endTime = System.nanoTime();
		long lTime = endTime - startTime;
		System.out.println("TIME : " + lTime);
	}

}
