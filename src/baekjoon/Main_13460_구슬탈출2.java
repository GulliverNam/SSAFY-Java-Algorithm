package baekjoon;

import java.io.*;
import java.util.*;

public class Main_13460_구슬탈출2 {
	
	static int N, M;
	static char[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		/**
		 * 목표: 빨간구슬을 빼는 것 / 파란구슬은 구멍에 들어가면 안됨
		 * 중력으로 굴리기 -> 위/아래/왼쪽/오른쪽
		 * 빨간구슬, 파란구슬 동시에 빠져도 실패
		 * 기울이는 동작을 그만하는 것은 더이상 구슬이 움직이지 않을 때 / 10번 이하로 못 뺄때
		 */
		int[] red = null;
		int[] blue = null;
		for (int i = 0; i < N; i++) {
			char[] line = br.readLine().trim().toCharArray();
			for (int j = 0; j < line.length; j++) {
				map[i][j] = line[j];
				if(map[i][j] == 'R'){
					red = new int[] {i,j};
					map[i][j] = '.';
				} else if(map[i][j] == 'B') {
					blue = new int[] {i,j};
					map[i][j] = '.';
				}
			}
		}
		
		answer = Integer.MAX_VALUE;
		action(red, blue, 0);
		System.out.println(answer == Integer.MAX_VALUE? -1:answer);
		
	}

	private static void action(int[] red, int[] blue, int cnt) {
		if(cnt == 10 || answer <= cnt) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			int[] nr = red.clone();
			int[] nb = blue.clone();
			while(map[nr[0] + dr[i]][nr[1] + dc[i]] == '.') {
				nr[0] += dr[i];
				nr[1] += dc[i];
			}
			while(map[nb[0] + dr[i]][nb[1] + dc[i]] == '.') {
				nb[0] += dr[i];
				nb[1] += dc[i];
			}
			if(nr[0] == nb[0] && nr[1] == nb[1]) {
				if(map[nb[0]+dr[i]][nb[1]+dc[i]] == 'O' &&
						map[nr[0]+dr[i]][nr[1]+dc[i]] == 'O') {
					continue;
				}
				switch(i) {
				case 0:
					if(red[0] < blue[0]) {
						nb[0]++;
					}else {
						nr[0]++;
					}
					break;
				case 1:
					if(red[0] < blue[0]) {
						nr[0]--;
					}else {
						nb[0]--;
					}
					break;
				case 2:
					if(red[1] < blue[1]) {
						nb[1]++;
					}else {
						nr[1]++;
					}
					break;
				case 3:
					if(red[1] < blue[1]) {
						nr[1]--;
					}else {
						nb[1]--;
					}
					break;
				}	
			}
			if(map[nb[0]+dr[i]][nb[1]+dc[i]] == 'O') {
				continue;
			}
			if(map[nr[0]+dr[i]][nr[1]+dc[i]] == 'O') {
				answer = Math.min(answer, cnt+1);
				return;
			}
			action(nr, nb, cnt+1);
		}
	}

}
