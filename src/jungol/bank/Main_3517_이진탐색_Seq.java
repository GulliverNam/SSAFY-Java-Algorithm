package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3517_이진탐색_Seq {

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
		
		Q = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 0; i < Q; i++) {
			int find = Integer.parseInt(st.nextToken());
			int j = 0;
			for (; j < N; j++) {
				if(numbers[j] == find) {
					System.out.print(j+" ");
					break;
				}
			}
			if(j >= N) System.out.print(-1+" ");
		}
	}
	

}
