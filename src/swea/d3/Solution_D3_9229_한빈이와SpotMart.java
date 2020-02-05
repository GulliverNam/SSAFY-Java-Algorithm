package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_9229_한빈이와SpotMart {

	static int snacks[], N, M, Answer;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_9229_한빈이와SpotMart.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snacks = new int[N];
			Answer = 0;
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int i = 0; i < N; i++)
				snacks[i] = Integer.parseInt(st.nextToken());
			
			findMax(0, 0, 0);
			if(Answer == 0) Answer--;
			
			System.out.println("#"+testCase+" "+Answer);
		}
	}

	private static void findMax(int cnt, int sum, int n) {
		if(cnt == 2) {
			if(sum <= M)
				Answer = Math.max(Answer, sum);
			return;
		}
		for (int i = n; i < N; i++) {
			findMax(cnt+1, sum+snacks[i], i+1);
		}
		
	}

}
