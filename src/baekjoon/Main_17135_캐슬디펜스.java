package baekjoon;

import java.io.*;
import java.util.*;

public class Main_17135_캐슬디펜스 {
	
	static int N, M, D, answer;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 궁수 3명
		archer(1, 0, 0);
		System.out.println(answer);

	}

	private static void archer(int start, int cnt, int pick) {
		if(cnt == 3) {
			answer = Math.max(answer, attack(pick));
			return;
		}
		for (int j = start; j <= M; j++) {
			if((pick & 1<<j) == 0) {
				archer(j + 1, cnt + 1, pick | 1 << j);
			}
		}
	}

	private static int attack(int pick) {
		int[][] temp = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			temp[i] = map[i].clone();
		}
		int[] archer = new int[3];
		int idx = 0;
		for (int i = 1; i <= M; i++) {
			if((pick & 1<<i) != 0) {
				archer[idx++] = i;
			}
		}
		List<int[]> attacked = new ArrayList<int[]>();
		int answer = 0;
		for (int r = N+1; r > 0; r--) {
			for (int c : archer) {
				top:
				for (int d = 1; d <= D; d++) {
					for (int dc = -(d-1); dc <= d-1; dc++) {
						int dr = - (d - Math.abs(dc));
						int nr = r + dr;
						int nc = c + dc; 
						if(nr >= 1 && nr <= N && nc >= 1 && nc <= M && temp[nr][nc] != 0) {
							attacked.add(new int[] {nr,nc});
							break top;
						}
					}
				}
			}
			for (int[] enemy : attacked) {
				if(temp[enemy[0]][enemy[1]] != 0)
					answer++;
				temp[enemy[0]][enemy[1]] = 0;
			}
			attacked.clear();
		}
		return answer;
	}

}
