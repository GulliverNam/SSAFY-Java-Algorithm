package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main_2667_단지번호붙이기2 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/Main_2667_단지번호붙이기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int map[][] = new int[N][N];
		int visited[][] = new int[N][N];
		char[] c;
		for (int i = 0; i < N; i++) {
			c = br.readLine().trim().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = c[j] - '0';
			}
		}
		
		int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
		LinkedList<int[]> queue = new LinkedList<>();
		int danji = 1, current[];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 0 && visited[i][j] == 0) {
					visited[i][j] = danji;
					queue.add(new int[] {i, j});
					int ci, cj, ni, nj;
					while(!queue.isEmpty()) {
						current = queue.poll();
						ci = current[0];
						cj = current[1];
						for (int d = 0; d < 4; d++) {
							ni = ci + dir[d][0];
							nj = cj + dir[d][1];
							if(ni > -1 && nj > -1 && ni < N && nj < N && 
							  map[ni][nj] != 0 && visited[ni][nj] == 0) {
								visited[ni][nj] = danji;
								queue.add(new int[] {ni, nj});
							}
						}
					}
					danji++;
				}
			}
		}
		System.out.println(--danji);
		int answer[] = new int[danji], num;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				num = visited[i][j];
				if(num != 0) {
					answer[num-1]++;
				}
			}
		}
		Arrays.sort(answer);
		for (int i = 0; i < danji; i++) {
			System.out.println(answer[i]);
		}
		
	}

}
