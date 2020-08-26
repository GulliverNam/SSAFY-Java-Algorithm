package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_빵집_solution {

	static int R, C, answer, dir[][] = {{-1,1},{0,1},{1,1}};
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
		
		for (int i = 0; i < R; i++) {
			if(dfs(i,0)) answer++;
		}
		
		System.out.println(answer);
	}
	private static boolean dfs(int r, int c) { // 연결 가능하면 true 리턴
		int nr, nc;
		for (int d = 0; d < 3; d++) {
			nr = r + dir[d][0];
			nc = c + dir[d][1];
			if(nr > -1 && nr < R && map[nr][nc] == '.') {
				if(nc == C-1)
					return true;
				map[nr][nc] = 'x';
				if(dfs(nr,nc))
					return true;
			}
		}
		return false;
	}
	

}