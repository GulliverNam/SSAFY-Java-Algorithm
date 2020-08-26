package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_빵집 {

	static int R, C, answer, dir[][] = {{-1,-1},{0,-1},{1,-1}};
	static char map[][];
	static boolean finish;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/Main_3109_빵집.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		answer = 0;
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int maxIndex = 0;
		for (int i = 1; i < C-1; i++) {
			for (int j = 0; j < R; j++) {
				if(map[j][i] == 'x') {
					maxIndex = i;
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			finish = false;
			if(map[i][maxIndex] == '.')
				find(i, maxIndex);
		}
		for (char[] s : map) {
			System.out.println(s);
		}
		System.out.println(answer);
	}
	private static void find(int r, int c) {
		if(c == 0) {
			answer++;
			finish = true;
			return;
		}
		int nr, nc;
		for (int i = 0; i < 3; i++) {
			if(finish) return;
			nr = r + dir[i][0];
			nc = c + dir[i][1];
			if(nr > -1 && nr < R && map[nr][nc] == '.') {
				map[r][c] = 'p';
				find(nr,nc);
				if(finish) return;
			}
			
		}
		
	}
	

}