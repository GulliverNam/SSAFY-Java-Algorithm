package com.ssafy.sort;

import java.util.Arrays;

public class InsertSortTest {

	public static void main(String[] args) {
		int n = 10;
		int data[] = new int[n];
		for (int i = 0; i < n; i++) {
//			Math.random() 0 <= x < 1 의 랜덤 데이터 생성
//			0 <= x < 1000 범위의 데이터가 생성됨
			data[i] = (int)(Math.random()*10);
		}
		System.out.println(Arrays.toString(data));
		insertSort(data, n);
		System.out.println(Arrays.toString(data));

	}

	private static void insertSort(int[] data, int size) {
		int standard, target;
		// 1. 배열 전체 반복
		for (int i = 1; i < size; i++) {
			standard = data[i];
			target = i-1;
			// 2. 정렬하려는 데이터 insert 위치-1부터 0번째 까지 반복
			while(target >= 0 && standard < data[target]) {
				// 3. 비교 데이터가 standard보다 작으므로 뒤로 이동
				data[target+1] = data[target];
				target--;
			}
			// 4. 정렬될 위치에 standard 저장
			data[target+1] = standard;
		}
		
	}

}
