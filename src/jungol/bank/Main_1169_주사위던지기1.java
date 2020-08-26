package jungol.bank;

import java.util.Scanner;

public class Main_1169_주사위던지기1 {
	static int N, M, result[];

	public static void solution(int cnt, int start, int flag) {
		if(cnt == N) {
			for (int i : result)
				System.out.print(i+" ");
			System.out.println();
			return;
		}
		if(M == 1) {
			for(int i = 1; i <= 6; i++) {
				result[cnt] = i;
				solution(cnt+1, 0, 0);
			}
		} else if(M == 2) {
			for(int i = start; i <= 6; i++) {
				result[cnt] = i;
				solution(cnt+1, i, 0);
			}
		} else {
			for(int i = 1; i <= 6; i++) {
				if((flag & 1<<i) == 0) {
					result[cnt] = i;
					solution(cnt+1, 0, flag | 1<<i);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner("3 2");
		N = sc.nextInt();
		M = sc.nextInt();
		result = new int[N];
		solution(0, 1, 0);
		sc.close();
	}

}
