package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_2806_NQueen2 {

	static int n, answer;
	static boolean vertical[];
	static boolean diagonal1[];
	static boolean diagonal2[];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_2806_NQueen.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine().trim());
			vertical = new boolean[n];
			diagonal1 = new boolean[n*2-1];
			diagonal2 = new boolean[n*2-1];
			answer = 0;
			play(0);
			System.out.println("#"+tc+" "+answer);
		}
	}


	private static void play(int i) {
		if(i == n) {
			answer++;
			return;
		}
		for (int j = 0; j < n; j++) {
			if(!vertical[j] && !diagonal1[i + j] && !diagonal2[n - i + j - 1]) {
				vertical[j] = diagonal1[i + j] = diagonal2[n - i + j - 1] = true;
				play(i+1);
				vertical[j] = diagonal1[i + j] = diagonal2[n - i + j - 1] = false;
			}
		}
		
	}
}
