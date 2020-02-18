package jungol.bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main_1459_숫자고르기 {
	
	static int N, nums[];
	static boolean check[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine().trim());
		nums = new int[N+1];
		check = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(br.readLine().trim());
			if(i == nums[i])
				check[i] = true;
		}
		for (int i = 1; i <= N; i++) {
			dfs(i, check.clone(), new LinkedList<Integer>());
		}
	}

	private static void dfs(int idx, boolean check[], LinkedList<Integer> list) {
		if(check[nums[idx]]) {
			check[idx] = true;
			list.add(nums[idx]);
			for (Integer i : list) {
				if(!check[i])
					return;
			}
			System.out.println(list.toString());
			System.out.println();
			return;
		}
		check[idx] = true;
		list.add(nums[idx]);
		dfs(nums[idx], check, list);
	}

}
