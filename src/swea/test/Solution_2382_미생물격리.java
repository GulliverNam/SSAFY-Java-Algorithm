package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Solution_2382_미생물격리 {
	
	static int dir[][] = {{0,0},{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/test/Solution_2382_미생물격리.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		int N, M, K;
		Micro map[][];
		LinkedList<Micro> micros = new LinkedList<Micro>();
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new Micro[N][N];
			int r, c, n, d;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine().trim());
				r = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				n = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken());
				micros.add(new Micro(r, c, n, d));
				map[r][c] = micros.peek();
			}
			Collections.sort(micros, new Comparator<Micro>() {
				@Override
				public int compare(Micro o1, Micro o2) {
					if(o1.r == o2.r)
						return o1.c - o2.c;
					return o1.r - o2.r;
				}
			});
			int nr, nc;
			for (int t = 0; t < M; t++) {
			}
			System.out.println("#"+tc);
			micros.clear();
		}
		
	}
	
	static class Micro{
		int r;
		int c;
		int n;
		int dir;
		public Micro(int r, int c, int n, int dir) {
			this.r = r;
			this.c = c;
			this.n = n;
			this.dir = dir;
		}
	}

}
