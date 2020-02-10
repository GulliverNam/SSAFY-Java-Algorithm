package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Main_2667_단지번호붙이기_DFS_recur {
	
	static int map[][], N, danji;
	static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/Main_2667_단지번호붙이기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		danji = 0;
		char[] c;
		for (int i = 0; i < N; i++) {
			c = br.readLine().trim().toCharArray(); // 속도 : toCharArray() > charAt(int index)
			for (int j = 0; j < N; j++) {
				map[i][j] = c[j] - '0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					++danji;
					dfs(i,j);
				}
			}
		}
		
		System.out.println(danji);
		int answer[] = new int[danji], num;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				num = map[i][j] - 1;
				if(num > 0) {
					answer[num-1]++;
				}
			}
		}
		Arrays.sort(answer);
		for (int i = 0; i < danji; i++) {
			System.out.println(answer[i]);
		}
		
	}

	private static void dfs(int i, int j) {
		int ni, nj;
		if(map[i][j] == 1) {
			map[i][j] += danji;
			for (int d = 0; d < 4; d++) {
				ni = i + dir[d][0];
				nj = j + dir[d][1];
				if(ni > -1 && nj > -1 && ni < N && nj < N && map[ni][nj] == 1)
					dfs(ni,nj);
			}
		}
	}

}
