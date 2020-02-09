package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기2 {

	static int N, W, H, Map[][], Answer;
	static int Dir[][] = {{0,-1},{0,1},{1,0},{-1,0}};
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/swea/test/Solution_5656_벽돌깨기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			Map = new int[H][W];
			Answer = Integer.MAX_VALUE;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < W; j++) {
					Map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			findAllCase(0, new int[N]);
			System.out.println("#"+testCase+" "+Answer);
		}

	}

	private static void findAllCase(int cnt, int[] arr) {
		if(cnt == N) {
			breakBrick(arr);
			return;
		}
		for (int i = 0; i < W; i++) {
			arr[cnt] = i;
			findAllCase(cnt+1, arr);
		}
		
	}

	private static void breakBrick(int arr[]) {
		LinkedList<int[]> deque = new LinkedList<int[]>();
		int temp[][] = new int[H][W];
		for (int i = 0; i < H; i++) {
			System.arraycopy(Map[i], 0, temp[i], 0, W);
		}
		int ci, cj, ni, nj, current[];
		
		
		for (int i = 0; i < N; i++) {
			nj = arr[i];
			for (ni = 0; ni < H; ni++) {
				if(temp[ni][nj] != 0) {
					break;
				}
			}
			if(ni != H)
				deque.add(new int[] {ni,nj});
			
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
			
		}
		int num = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(temp[i][j] != 0)
					num++;
			}
		}
		Answer = Math.min(Answer, num);
		
	}

}
