package jungol.bank;

import java.util.Scanner;

/**
 * n^2비교 -> 8만 번 -> 약 64억번 비교
 * Scanner 사용하면 오류
 * Buffered Reader
 * @author NamGiwon
 *
 */

public class Main_1141_불쾌한날 {

	public static void main(String[] args) {
		Scanner sc = new Scanner("6 5 2 4 2 6 1");
		
		int N = sc.nextInt();
		long cows[] = new long[N];
		for (int i = 0; i < N; i++)
			cows[i] = sc.nextLong();
		long answer = 0;
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				if(cows[i] > cows[j]) answer++;
				else break;
			}
		}
		
		System.out.println(answer);
		
		sc.close();
	}

}
