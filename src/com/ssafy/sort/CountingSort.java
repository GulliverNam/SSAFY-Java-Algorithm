package com.ssafy.sort;

import java.util.Arrays;

/**
 * CountingSort: 시간복잡도가 O(n)으로 끝나는 유일한 sorting방법
 * - 데이터의 크기가 크면 공간복잡도가 커짐
 * - 정수데이터가 아닐 시 사용할 수 없음
 * @author NamGiwon
 *
 */

public class CountingSort {

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
		for (int d : data) // 데이터가 counts 배열의 index로 활용
			counts[d]++;
		
		// step3. count배열에 값을 누적하기 - 앞의 값과 현재 값을 더해서 현재 index에 누적
		for (int i = 1; i < maxNum+1; i++)
			counts[i] += counts[i-1];
		
		// step4. 데이터 배열과 count 배열을 이용해 정렬하기
		int n, length = data.length;
		int[] temp = new int[length];
		for (int i = length-1; i > -1; i--) {
			n = data[i];
			temp[--counts[n]] = n;
		}
		System.out.println("sorted array:\t"+Arrays.toString(temp));
		
		long endTime = System.nanoTime();
		// Time Check
		long lTime = endTime - startTime;
		System.out.println("TIME : " + lTime);

	}

}
