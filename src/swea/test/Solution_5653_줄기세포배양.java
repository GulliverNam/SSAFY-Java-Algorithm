package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
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
		for (int testCase = 1; testCase <= 5; testCase++) {
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
					if(map[i][j] != 0)
						Queue.add(new int[] {i,j,map[i][j], 0, 0});
					// i 좌표, j 좌표, lifeTime, k(상태변화 or 배양 시점), 상태(0:비활성, 1:활성, 2:활성 후 비활성)
				}
			}
			for (int time = 1; time <= K; time++) {
				Queue = culture(time);
			}
			System.out.println("#"+testCase+" "+Queue.size());
			Queue.clear();
			
		}
	}
	private static LinkedList<int[]> culture(int time) {
		LinkedList<int[]> temp = new LinkedList<>();
		int length = Queue.size();
		int cur[], ci, cj, life, k, status, ni, nj;
		for (int i = 0; i < length; i++) {
			cur = Queue.poll();
			ci = cur[0];
			cj = cur[1];
			life = cur[2];
			k = cur[3];
			status = cur[4];
			switch(status) {
			case 0:
				if(life+k == time) {
					k = time;
					status = 1;
				}
				temp.add(new int[] {ci, cj, life, k, status});
				break;
			case 1:
				for (int j = 0; j < 4; j++) {
					ni = ci + dir[j][0];
					nj = cj + dir[j][1];
					if(map[ni][nj] == 0) {
						temp.add(new int[] {ni, nj, life, time, 0});
					}
				}
				if(life == 1) break;
				temp.add(new int[] {ci, cj, life, k, 2});
				break;
			case 2:
				if(life+k == time) break;
				temp.add(new int[] {ci, cj, life, k, status});
				break;
			}
		}
		temp.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0] && o1[1] == o2[1])
					return o1[2] > o2[2] ? 1 : -1;
				if(o1[0] == o2[0])
					return o1[1] > o2[1] ? 1 : -1;
				return o1[0] > o2[0] ? 1 : -1;
			}
		});
		int prev[], remove[] = new int[temp.size()];
		int idx = 0;
		for (int i = 0; i < temp.size(); i++) {
			cur = temp.get(i);
			if(cur[4] == 0 && cur[3] == time) {
				if(map[cur[0]][cur[1]] == 0)
					map[cur[0]][cur[1]] = cur[2];
				else {
					prev = temp.get(i-1);
					if(prev[0] == cur[0] && prev[1] == cur[1]) {
						map[cur[0]][cur[1]] = cur[2];
						remove[idx++] = i-1;
					}
				}
			}
		}
		for (int i = idx-1; i > -1; i--) {
			temp.remove(remove[i]);
		}
		
		return temp;
		
	}

}
