package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_2383_점심식사시간 {
	static int N;
	static LinkedList<People> peoples = new LinkedList<>();
	static LinkedList<Stair> stairs = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/test/Solution_2383_점심식사시간.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			char c;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					c = st.nextToken().charAt(0);
					if(c == '1')
						peoples.add(new People(i, j));
					else if(c > '1')
						stairs.add(new Stair(i, j, c - '0'));
				}
			}
			
			for (int i = 0; i < peoples.size(); i++) {
				subset(i, 0, new boolean[peoples.size()]);
			}
			
			System.out.println("#"+tc+" ");
			peoples.clear();
			stairs.clear();
		}
	}
	
	private static void subset(int idx, int cnt, boolean[] set) {
		if(cnt == idx) {
			return;
		}
	}

	static class People{
		int r;
		int c;
		public People(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "People [r=" + r + ", c=" + c + "]";
		}
		
	}
	
	static class Stair{
		LinkedList<People> using;
		int r;
		int c;
		int time;
		public Stair(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}

		public void add(People p) {
			using.add(p);
		}

		@Override
		public String toString() {
			return "time=" + time;
		}
		
	}
	
}
