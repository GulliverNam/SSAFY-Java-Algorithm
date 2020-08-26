package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 부분집합 & 조합 문제
 */

public class Solution_2115_벌꿀채취 {
	
	static int N, M, C, answer, map[][];
	static int tmp, result;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/test/Solution_2115_벌꿀채취.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N+2][N+2];
			answer = 0;
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int temp[] = new int[M];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N-M+1; j++) {
					temp[0] = map[i][j];
					getFirst(i, j, 0, temp.clone());
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
	

	private static void getFirst(int r, int c, int cnt, int[] select) {
		if(cnt == M-1) {
			tmp = 0;
			findMax(select,0,0,0);
			result = tmp;
			int temp[] = new int[M];
			for (int i = (N-c <= M ? r:r+1); i <= N; i++) {
				for (int j = (i == r ? c+1:1); j <= N-M+1; j++) {
					temp[0] = map[i][j];
					getSecond(i,j,0,temp.clone());
				}
			}
			return;
		}
		select[cnt+1] = map[r][c+1];
		getFirst(r, c+1, cnt+1, select);
	}


	private static void getSecond(int r, int c, int cnt, int[] select) {
		if(cnt == M-1) {
			tmp = 0;
			findMax(select, 0, 0, 0);
			answer = Math.max(answer, result+tmp);
			return;
		}
		select[cnt+1] = map[r][c+1];
		getSecond(r, c+1, cnt+1, select);
	}


	private static void findMax(int[] arr, int start, int sum, int powSum) {
		tmp = Math.max(tmp, powSum);
		for (int i = start; i < M; i++) {
			if(sum+arr[i] <= C) {
				findMax(arr, i+1, sum+arr[i], powSum+arr[i]*arr[i]);
			}
		}
	}
}
