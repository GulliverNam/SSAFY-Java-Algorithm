package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_7576_토마토 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/Main_7576_토마토.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int box[][] = new int[N+2][M+2];
		boolean check[][] = new boolean[N+2][M+2];
		int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
		LinkedList<int[]> tomato = new LinkedList<>();
		
		for (int i = 0; i < N+2; i++) {
			Arrays.fill(box[i], -1);
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 1) {
					tomato.add(new int[] {i,j});
					check[i][j] = true;
				}
			}
		}
		
		int cur[], ci, cj, ni, nj;
		int length, answer = 0;
		while(!tomato.isEmpty()) {
			length = tomato.size();
			for (int i = 0; i < length; i++) {
				cur = tomato.poll();
				ci = cur[0];
				cj = cur[1];
				for (int d = 0; d < 4; d++) {
					ni = ci + dir[d][0];
					nj = cj + dir[d][1];
					if(box[ni][nj] == 0 && !check[ni][nj]) {
						box[ni][nj] = 1;
						check[ni][nj] = true;
						tomato.add(new int[] {ni,nj});
					}
				}
			}
			answer++;
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if(!check[i][j] && box[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(--answer);
		
	}

}
