package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1661_미로탈출로봇_BFS {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/bank/Main_1661_미로탈출로봇.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int maze[][] = new int[Y+1][X+1];
		int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
		
		st = new StringTokenizer(br.readLine().trim(), " ");
		int sx = Integer.parseInt(st.nextToken());
		int sy = Integer.parseInt(st.nextToken());
		int dx = Integer.parseInt(st.nextToken());
		int dy = Integer.parseInt(st.nextToken());
		
		char[] c;
		for (int i = 1; i <= Y; i++) {
			c = br.readLine().toCharArray();
			for (int j = 1; j <= X; j++) {
				maze[i][j] = c[j-1] - '0';
			}
		}
		
		LinkedList<int[]> queue = new LinkedList<>();
		boolean visit[][] = new boolean[Y+1][X+1];
		queue.add(new int[] {sy, sx, 0});
		visit[sy][sx] = true;
		int answer = 0;
		int cx, cy, cnt, nx, ny, current[];
		while(!queue.isEmpty()) {
			current = queue.poll();
			cy = current[0];
			cx = current[1];
			cnt = current[2];
			System.out.println(cy+" "+cx+" "+cnt);
			if(cx == dx && cy == dy) {
				answer = cnt;
				break;
			}
			for (int i = 0; i < 4; i++) {
				nx = cx + dir[i][0];
				ny = cy + dir[i][1];
				if(nx > 0 && ny > 0 && nx <= X && ny <= Y &&
			       maze[ny][nx] == 0 && !visit[ny][nx]) {
					visit[ny][nx] = true;
					queue.add(new int[] {ny, nx, cnt+1});
				}
			}
		}
		System.out.println(answer);
	}

}
