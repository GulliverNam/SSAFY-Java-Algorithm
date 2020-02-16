package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {
	static int N, M, D, answer, map[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/Main_17135_캐슬디펜스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		play(-1,0, new boolean[M]);
		System.out.println(answer);

	}

	private static void play(int idx, int cnt, boolean set[]) {
		if(cnt == 3) {
			attack(set);
			return;
		}
		for (int i = idx+1; i < M; i++) {
			set[i] = true;
			play(i, cnt+1, set);
			set[i] = false;
		}
	}

	private static void attack(boolean[] set) {
		int nr, nc, num = 0;
		int temp[][] = new int[N][M];
		for (int i = 0; i < N; i++)
			System.arraycopy(map[i], 0, temp[i], 0, M);
		LinkedList<int[]> killed = new LinkedList<int[]>();
		for (int r = N; r > 0; r--) {
			for (int c = 0; c < M; c++) {
				if(set[c]) {
					top:
					for (int d = 1; d <= D; d++) {
						for (int k = -(d-1); k <= d-1; k++) {
							nr = r - (d - Math.abs(k));
							nc = c + k;
							if(nr > -1 && nc > -1 && nc < M && temp[nr][nc] == 1) {
								killed.add(new int[] {nr,nc});
								break top;
							}
						}
					}
				}
			}
			int e[];
			for (int i = 0, size = killed.size(); i < size; i++) {
				e = killed.poll();
				if(temp[e[0]][e[1]] == 1) {
					temp[e[0]][e[1]] = 0;
					num++;
				}
			}
		}
		answer = Math.max(answer, num);
	}

}
