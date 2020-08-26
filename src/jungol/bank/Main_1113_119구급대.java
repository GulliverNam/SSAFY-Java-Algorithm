package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1113_119구급대 {
	
	static int Map[][], Answer = Integer.MAX_VALUE;
	static int Dr, Dc, M, N;
	static int Dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean Visited[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/bank/Main_1113_119구급대.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		Map = new int[M][N];
		st = new StringTokenizer(br.readLine(), " ");
		Dr = Integer.parseInt(st.nextToken());
		Dc = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				Map[i][j] = Integer.parseInt(st.nextToken());
		}
		Visited = new boolean[M][N];
		bfs();
		System.out.println(Answer);
	}

	private static void bfs() {
		LinkedList<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0, -1, 0});
		int nr, nc, point[];
		int r, c, dir, cnt;
		while(!queue.isEmpty()) {
			point = queue.poll();
			r = point[0];
			c = point[1];
			dir = point[2];
			cnt = point[3];
			if(r == Dr && c == Dc) {
				Answer = Math.min(Answer, cnt);
				continue;
			}
			Visited[r][c] = true;
			for (int i = 0; i < 4; i++) {
				nr = r + Dir[i][0];
				nc = c + Dir[i][1];
				if(nr > -1 && nr < M && nc > -1 && nc < N && 
				   Map[nr][nc] == 1 && !Visited[nr][nc]) {
					if(dir == -1) queue.add(new int[] {nr, nc, i, cnt});
					else if(dir != i) queue.add(new int[] {nr, nc, i, cnt+1});
					else queue.add(new int[] {nr, nc, i, cnt});
				}
			}
			
		}
		
	}

}
