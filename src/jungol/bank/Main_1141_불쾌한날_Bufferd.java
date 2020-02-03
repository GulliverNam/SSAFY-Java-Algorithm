package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * n^2비교 -> 8만 번 -> 약 64억번 비교
 * Scanner 사용하면 오류
 * Buffered Reader
 * @author NamGiwon
 *
 */

public class Main_1141_불쾌한날_Bufferd {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/bank/Main_1141_불쾌한날.txt"));
		// BufferedReader가 Scanner보다 빠르다
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine().trim());
		long cows[] = new long[N];
		for (int i = 0; i < N; i++)
			cows[i] = Integer.parseInt(in.readLine().trim());
		long answer = 0;
		
		// 배열의 인덱스로 접근하면 heap에 자주 접근하기 때문에 속도가 느리다.
		// -> 지역변수로 처리하면 속도가 빨라짐
		long current;
		for (int i = 0; i < N-1; i++) {
			current = cows[i];
			for (int j = i+1; j < N; j++) {
				if(current > cows[j]) answer++;
				else break;
			}
		}
		
		System.out.println(answer);
		
	}

}
