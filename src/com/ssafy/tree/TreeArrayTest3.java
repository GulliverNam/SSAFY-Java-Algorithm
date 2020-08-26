package com.ssafy.tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class TreeArrayTest3 {

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
		insertTree(temp, 1, N);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void insertTree(int[] data, int start, int end) {
		LinkedList<int[]> queue = new LinkedList<>();
		int index = 1;
		queue.offer(new int[] {index, start, end});
		int mid, node[];
		while(!queue.isEmpty()) {
			node = queue.poll();
			index = node[0];
			start = node[1];
			end = node[2];
			mid = temp[(start+end) >> 1];
			arr[index] = mid;
			if(index<<1 <= N) queue.offer(new int[] {index<<1, start, mid-1});
			if((index<<1)+1 <= N)queue.offer(new int[] {(index<<1)+1, mid+1, end});			
		}
	}
}
