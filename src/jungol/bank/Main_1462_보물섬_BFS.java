package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1462_보물섬_BFS {
	
	static int r, c, max;
	static char map[][];
	static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static LinkedList<int[]> queue = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/bank/Main_1462_보물섬.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().trim().toCharArray();
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(map[i][j] == 'L')
					bfs(i, j);
			}
		}
		System.out.println(max);
	}
	
	private static void bfs(int sr, int sc) {
		boolean visit[][] = new boolean[r][c];
		queue.add(new int[] {sr,sc,0});
		visit[sr][sc] = true;
		int cur[], nc, nr, i, j, dist;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			i = cur[0];
			j = cur[1];
			dist = cur[2];
			if(max < dist)
				max = dist;
			for (int d = 0; d < 4; d++) {
				nr = i + dir[d][0];
				nc = j + dir[d][1];
				if(nr > -1 && nc > -1 && nr < r && nc < c &&
				   !visit[nr][nc] && map[nr][nc] == 'L') {
					visit[nr][nc] = true;
					queue.add(new int[] {nr, nc, dist+1});
				}
			}
		}
		
	}

}
