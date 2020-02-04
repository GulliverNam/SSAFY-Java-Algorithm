package com.ssafy.tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class TreeArrayTest {

	static int arr[], N;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/tree.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N+1];
		
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		System.out.println("[preOrder]");
		preOrder(1);
		System.out.println();
		System.out.println("[inOrder]");
		inOrder(1);
		System.out.println();
		System.out.println("[postOrder]");
		postOrder(1);
	}
	
	private static void preOrder(int i) {
		System.out.print(arr[i]+" ");
		if(i<<1 <= N) preOrder(i<<1);
		if((i<<1)+1 <= N) preOrder((i<<1)+1);
	}
	
	private static void inOrder(int i) {
		if(i<<1 <= N) inOrder(i<<1);
		System.out.print(arr[i]+" ");
		if((i<<1)+1 <= N) inOrder((i<<1)+1);
	}

	private static void postOrder(int i) {
		if(i<<1 <= N) postOrder(i<<1);
		if((i<<1)+1 <= N) postOrder((i<<1)+1);
		System.out.print(arr[i]+" ");
	}
}
