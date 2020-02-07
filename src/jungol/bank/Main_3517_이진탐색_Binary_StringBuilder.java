package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3517_이진탐색_Binary_StringBuilder {

	static int N, Q, numbers[];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/bank/Main_3517_이진탐색.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		numbers = new int[N];
		
		st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 0; i < N; i++)
			numbers[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(numbers);
		Q = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder(Q*2);
		st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 0; i < Q; i++) {
			sb.append(binary(Integer.parseInt(st.nextToken()), 0, N));
			sb.append(" ");
		}
		System.out.println(sb);
	}
	private static int binary(int target, int start, int end) {
		System.out.println(start+" "+end);
		if(start >= end) return -1;
		int mid = (start + end) >> 1;
		int data = numbers[mid];
		if(data == target)
			return mid;
		else if(data > target)
			return binary(target, start, mid);
		else
			return binary(target, mid+1, end);
	}
}
