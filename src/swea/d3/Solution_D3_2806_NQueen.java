package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_2806_NQueen {

	static int Map[][], N, Answer;
	static boolean Vertical[];
	static boolean Diagonal1[];
	static boolean Diagonal2[];
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/Solution_D3_2806_NQueen.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine().trim());
			Map = new int[N][N];
			Vertical = new boolean[N];
			Diagonal1 = new boolean[N*2-1];
			Diagonal2 = new boolean[N*2-1];
			Answer = 0;
			
			queen(0);
			System.out.println("#"+testCase+" "+Answer);
		}
	}


	private static void queen(int cnt) {
		if(cnt == N) {
			Answer++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if(Map[cnt][i] == 0 && !Vertical[i] && !Diagonal1[cnt-i+N-1] && !Diagonal2[cnt+i]) {
				Vertical[i] = Diagonal1[cnt-i+N-1] = Diagonal2[cnt+i] = true;
				Map[cnt][i] = 1;
				queen(cnt+1);
				Map[cnt][i] = 0;
				Vertical[i] = Diagonal1[cnt-i+N-1] = Diagonal2[cnt+i] = false;
			}
		}
	}

}
