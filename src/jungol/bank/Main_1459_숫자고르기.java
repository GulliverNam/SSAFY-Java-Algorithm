package jungol.bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1459_숫자고르기 {
	
	static int N, nums[];
	static boolean check[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine().trim());
		nums = new int[N+1];
		check = new boolean[N+1];
		for (int i = 1; i <= N; i++)
			nums[i] = Integer.parseInt(br.readLine().trim());
		
	}
}
