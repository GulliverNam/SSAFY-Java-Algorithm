package swea.d5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D5_7793_오나의여신님 {
	
	static int N, M, answer;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static char map[][];
	static Queue<int[]> devil, suyeon;
	static boolean visited[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N+2][M+2];
			devil = new LinkedList<>();
			suyeon = new LinkedList<>();
			visited = new boolean[N+1][M+1];
			for (int i = 1; i <= N; i++) {
				String str = br.readLine().trim();
				for (int j = 0; j < M; j++) {
					switch(str.charAt(j)) {
						case '*': devil.add(new int [] {i,j+1}); map[i][j+1] = str.charAt(j); break;
						case 'S': suyeon.add(new int [] {i,j+1}); visited[i][j+1] = true; map[i][j+1] = '.'; break;
						default:
							map[i][j+1] = str.charAt(j); break;
					}
				}
			}
			System.out.print("#"+tc+" ");
			if(bfs())
				System.out.println(answer+1);
			else
				System.out.println("GAME OVER");
		}
	}

	private static boolean bfs() {
		answer = 0;
		top:
		while(true) {
			int nr, nc, size = devil.size(), cur[];
			for (int i = 0; i < size; i++) {
				cur = devil.poll();
				for (int d = 0; d < 4; d++) {
					nr = cur[0] + dr[d];
					nc = cur[1] + dc[d];
					if(map[nr][nc] == '.') {
						map[nr][nc] = '*';
						devil.offer(new int[] {nr,nc});
					}
				}
			}
			size = suyeon.size();
			for (int i = 0; i < size; i++) {
				cur = suyeon.poll();
				for (int d = 0; d < 4; d++) {
					nr = cur[0] + dr[d];
					nc = cur[1] + dc[d];
					if(map[nr][nc] == 'D')
						break top;
					if(map[nr][nc] == '.' && !visited[nr][nc]) {
						visited[nr][nc] = true;
						suyeon.offer(new int[] {nr,nc});
					}
				}
			}
			if(suyeon.size() == 0)
				return false;
			answer++;
		}
		return true;
	}

}
