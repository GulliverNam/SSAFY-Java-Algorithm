package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_5653_줄기세포배양 {
	
	static LinkedList<int[]> Queue = new LinkedList<>();
	static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static int map[][];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/test/Solution_5653_줄기세포배양.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		int N, M, K;
		int rStart, cStart;
		for (int testCase = 1; testCase <= T; testCase++) {
			map = new int[1000][1000];
			st = new StringTokenizer(br.readLine().trim(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			rStart = 500 - N/2;
			cStart = 500 - M/2;
			for (int i = rStart; i < rStart+N; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = cStart; j < cStart+M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					Queue.add(new int[] {i,j,map[i][j], 0, 0});
					// i 좌표, j 좌표, lifeTime, k(상태변화 or 배양 시점), 상태(0:비활성, 1:활성, 2:죽음)
				}
			}
			for (int time = 1; time <= K; time++) {
				curlture();
			}
			Queue.clear();
			
		}
	}
	private static void curlture() {
		LinkedList<int[]> temp = new LinkedList<>();
		int length = Queue.size();
		int current[], ci, cj, life, k, status, ni, nj;
		for (int time = 0; time < length; time++) {
			current = Queue.poll();
			ci = current[0];
			cj = current[1];
			life = current[2];
			k = current[3];
			status = current[4];
			switch(status) {
			case 0:
				if(life+k == time) {
					k = k+time;
					status = 1;
				}
				temp.add(new int[] {ci, cj, life, k, status});
				break;
			case 1:
				for (int i = 0; i < 4; i++) {
					ni = ci + dir[i][0];
					nj = cj + dir[i][1];
				}
				break;
			case 2:
				break;
			}
		}
		
	}

}
