package com.ssafy.tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class TreeArrayTest2 {

	static int arr[], temp[], N;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/tree2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N+1];
		temp = new int[N+1];
		
		for (int i = 1; i <= N; i++)
			temp[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(temp);
		insertTree(1,1,N);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * 트리를 구성하는 함수
	 * @param index		트리를 구성할 데이터
	 * @param start		data의 시작위치
	 * @param end		data의 끝위치
	 */
	private static void insertTree(int index, int start, int end) {
		if(index <= N) {
			int mid = (start+end) >> 1;
			arr[index] = temp[mid];
			insertTree(index<<1, start, mid-1);
			insertTree((index<<1)+1, mid+1, end);
		}
	}
}
