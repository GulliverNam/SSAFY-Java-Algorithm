package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2576_색종이2 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/Main_2576_색종이2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int paper[][] = new int[101][101];
		int N = Integer.parseInt(br.readLine().trim());
		int c, r;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			c = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			for (int j = r; j < r+10; j++) {
				for (int k = c; k < c+10; k++) {
					paper[j][k] = 1;
				}
			}
		}
		int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
		int answer = 0, ni, nj;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if(paper[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
						ni = i + dir[d][0];
						nj = j + dir[d][1];
						if(paper[ni][nj] == 0)
							answer++;
					}
				}
			}
		}
		System.out.println(answer);

	}

}
