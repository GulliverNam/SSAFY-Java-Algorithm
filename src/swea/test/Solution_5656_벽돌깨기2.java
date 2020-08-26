package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기2 {
	
	static int N, W, H, answer, map[][];
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/swea/test/Solution_5656_벽돌깨기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer = Integer.MAX_VALUE;
			game(0, map);
			System.out.println("#"+tc+" "+answer);
		}

	}

	private static void game(int cnt, int[][] map) {
		if(answer == 0)
			return;
		if(cnt == N) {
			int num = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(map[i][j] != 0) {
						num++;
						if(num > answer) return;
					}
				}
			}

			answer = Math.min(answer, num);
			return;
		}
		for (int i = 0; i < W ; i++) {
			game(cnt+1, breakBlock(i, map));
		}
		
	}
	private static int[][] breakBlock(int j, int[][] map) {
		int temp[][] = new int[H][W];
		for (int i = 0; i < H; i++)
			temp[i] = map[i].clone();
		LinkedList<int[]> queue = new LinkedList<>();
		for (int i = 0; i < H; i++) {
			if(temp[i][j] != 0) {
				queue.offer(new int[] {i, j});
				break;
			}
		}
		if(queue.size() == 0)
			return map;
		int r, c, num, cur[];
		while(!queue.isEmpty()) {
			cur = queue.poll();
			r = cur[0]; c = cur[1];
			num = temp[r][c] - 1;
			temp[r][c] = 0;
			for (int i = - num; i <= num; i++) {
				if(r + i > -1 && r + i < H && temp[r + i][c] != 0)
					queue.offer(new int[] {r+i, c});
				if(c + i > -1 && c + i < W && temp[r][c + i] != 0)
					queue.offer(new int[] {r, c+i});
			}
		}
		for (c = 0; c < W; c++) {
			for (r = 0; r < H; r++) {
				if(temp[r][c] != 0) {
					queue.push(new int[] {temp[r][c]});
					temp[r][c] = 0;
				}
			}
			
			while(!queue.isEmpty()) {
				temp[--r][c] = queue.pop()[0];
			}
		}
		return temp;
	}
}
