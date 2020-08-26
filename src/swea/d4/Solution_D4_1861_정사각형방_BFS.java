package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방_BFS {
	
	static int N, room[][], max, answer;
	static int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean visit[][];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/Solution_D4_1861_정사각형방.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine().trim());
			room = new int[N+2][N+2];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 1; j <= N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					find(i,j);
				}
			}
			
			System.out.println("#"+testCase+" "+answer+" "+max);
		}
	}

	private static void find(int i, int j) {
		visit = new boolean[N+2][N+2];
		LinkedList<int[]> queue = new LinkedList<>();
		queue.add(new int[] {i,j,1});
		visit[i][j] = true;
		int cur[], r, c, nr, nc;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			r = cur[0];
			c = cur[1];
			if(max < cur[2]) {
				max = cur[2];
				answer = room[i][j];
			}
			if(max == cur[2])
				answer = Math.min(answer, room[i][j]);
			for (int d = 0; d < 4; d++) {
				nr = r + dir[d][0];
				nc = c + dir[d][1];
				if(room[nr][nc] != 0 && room[nr][nc] == room[r][c]+1) {
					queue.add(new int[] {nr,nc,cur[2]+1});
				}
			}
		}
		
	}

}
