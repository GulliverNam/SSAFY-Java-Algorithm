package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1 {
	
	static int N, answer;
	static boolean map[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		map = new boolean[N+2][N+2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= N; j++) {
				if(st.nextToken().charAt(0) == '0')
					map[i][j] = true;
			}
		}
		findPath(1,1,1,2);
		System.out.println(answer);
	}

	private static void findPath(int r1, int c1, int r2, int c2) {
		if(map[r2+1][c2] && map[r2][c2+1] && map[r2+1][c2+1]) {
			if(r2+1 == N && c2+1 == N)
				answer++;
			else
				findPath(r2, c2, r2+1, c2+1);
		}
		if(c1 == c2-1 && map[r2][c2+1]) {
			if(r2 == N && c2+1 == N)
				answer++;
			else
				findPath(r2, c2, r2, c2+1);
		}
		if(r1 == r2-1 && map[r2+1][c2]) {
			if(r2+1 == N && c2 == N)
				answer++;
			else
				findPath(r2, c2, r2+1, c2);
		}		
	}
	
}
