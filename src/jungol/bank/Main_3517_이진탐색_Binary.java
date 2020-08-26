package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3517_이진탐색_Binary {

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
		st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 0; i < Q; i++) {
			System.out.print(binary(Integer.parseInt(st.nextToken()), 0, N)+" ");
		}
	}
	private static int binary(int target, int start, int end) {
		if(start > end) return -1;
		int mid = (start + end) >> 1;
		int data = numbers[mid];
		if(data == target)
			return mid;
		else if(data > target)
			return binary(target, start, mid-1);
		else
			return binary(target, mid+1, end);
	}
	

}
