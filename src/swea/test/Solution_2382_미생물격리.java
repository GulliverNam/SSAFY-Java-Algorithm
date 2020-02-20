package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Solution_2382_미생물격리 {
	
	static int N, M, K, dir[][] = {{0,0},{-1,0},{1,0},{0,-1},{0,1}};
	static LinkedList<Micro> micros = new LinkedList<Micro>();
	static LinkedList[][] map;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/test/Solution_2382_미생물격리.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		long answer;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new LinkedList[N][N];
			answer = 0;
			int r, c, d;
			long n;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine().trim());
				r = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				n = Long.parseLong(st.nextToken());
				d = Integer.parseInt(st.nextToken());
				micros.add(new Micro(r, c, n, d));
			}
			for (int t = 0; t < M; t++) {
				timeFlow();
			}
			
			for (Micro m : micros) {
				answer += m.n;
			}
			System.out.println("#"+tc+" "+answer);
			micros.clear();
		}
		
	}
	
	private static void timeFlow() {
		Micro cur;
		for (int i = 0, size = micros.size(); i < size; i++) {
			cur = micros.poll();
			cur.r += dir[cur.dir][0];
			cur.c += dir[cur.dir][1];
			if(cur.r == 0 || cur.c == 0 || cur.r == N-1 || cur.c == N-1) {
				cur.dir = cur.dir % 2 == 0 ? cur.dir-1 : cur.dir+1;
				cur.n /= 2;
				if(cur.n == 0)
					continue;
			}
			if(map[cur.r][cur.c] == null)
				map[cur.r][cur.c] = new LinkedList<Micro>();
			map[cur.r][cur.c].offer(cur);
			micros.offer(cur);
		}
		int maxD = 0;
		long maxN, sumN;
		LinkedList<Micro> temp = new LinkedList<Micro>(micros);
		for (Micro m: temp) {
			if(map[m.r][m.c] != null && map[m.r][m.c].size() > 1) {
				sumN = 0;
				maxN = 0;
				for (int i = 0, size = map[m.r][m.c].size(); i < size; i++) {
					cur = (Micro)(map[m.r][m.c].poll());
					micros.remove(cur);
					sumN += cur.n;
					if(maxN < cur.n) {
						maxN = cur.n;
						maxD = cur.dir;
					}
				}
				micros.offer(new Micro(m.r, m.c, sumN, maxD));
			}
			map[m.r][m.c] = null;
		}
	}

	static class Micro{
		int r;
		int c;
		long n;
		int dir;
		public Micro(int r, int c, long n, int dir) {
			this.r = r;
			this.c = c;
			this.n = n;
			this.dir = dir;
		}
	}

}
