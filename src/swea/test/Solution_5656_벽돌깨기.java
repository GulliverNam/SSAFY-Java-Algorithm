package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {

	static int N, W, H, Answer;
	static int Dir[][] = {{0,-1},{0,1},{1,0},{-1,0}};
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/swea/test/Solution_5656_벽돌깨기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		int map[][];
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			Answer = Integer.MAX_VALUE;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			findAllCase(0, map);
			System.out.println("#"+testCase+" "+Answer);
		}

	}

	private static void findAllCase(int cnt, int[][] arr) {
		if(cnt == N) {
			int num = 0;
			for (int[] r : arr) {
				for (int i : r) {
					if(i != 0)
						num++;
				}
			}
			Answer = Math.min(Answer, num);
			return;
		}
		for (int i = 0; i < W; i++) {
			findAllCase(cnt+1, breakBrick(i, arr));
		}
		
	}

	private static int[][] breakBrick(int j, int[][] arr) {
		LinkedList<int[]> deque = new LinkedList<int[]>();
		int temp[][] = new int[H][W];
		int i;
		for (i = 0; i < H; i++) {
			System.arraycopy(arr[i], 0, temp[i], 0, W);
		}
		
		for (i = 0; i < H; i++) {
			if(temp[i][j] != 0) {
				break;
			}
		}
		if(i != H)
			deque.add(new int[] {i, j});
		int ni, nj, ci, cj, current[];
		while(!deque.isEmpty()) {
			current = deque.poll();
			ci = current[0];
			cj = current[1];
			for (int dir = 0; dir < 4; dir++) {
				ni = ci;
				nj = cj;
				for (int k = 0; k < temp[ci][cj]-1; k++) {
					ni += Dir[dir][0];
					nj += Dir[dir][1];
					if(ni > -1 && nj > -1 && ni < H && nj < W && temp[ni][nj] != 0) {
						deque.add(new int[] {ni, nj});
					}
				}
			}
			temp[ci][cj] = 0;
		}
		for (int c = 0; c < W; c++) {
			int r = 0;
			for (; r < H; r++) {
				if(temp[r][c] != 0) {
					deque.push(new int[] {temp[r][c]});
					temp[r][c] = 0;
				}
			}
			while(!deque.isEmpty())
				temp[--r][c] = deque.pop()[0];
		}
		return temp;
			
	}

}
