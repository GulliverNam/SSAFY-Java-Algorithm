package jungol.bank;

import java.util.Scanner;

public class Main_1175_주사위던지기2 {
	static int N, M;
	static int result[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner("3 10");
		N = sc.nextInt();
		M = sc.nextInt();
		result = new int[N];
		permutation(0, 0);
		sc.close();
	}
	
	public static void permutation(int cnt, int sum) {
		if(cnt == N) {
			if(sum == M) {
				for(int i:result)
					System.out.print(i+" ");
				System.out.println();
			}
			return;
		}
		for(int i = 1; i <= 6; i++) {
			result[cnt] = i;
			permutation(cnt+1, sum+i);
		}
	}
}
