package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_2383_점심식사시간 {
	
	static int N, answer;
	static LinkedList<People> peoples = new LinkedList<>();
	static LinkedList<Stair> stairs = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/test/Solution_2383_점심식사시간.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			answer = Integer.MAX_VALUE;
			int num;
			int idx = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					num = Integer.parseInt(st.nextToken());
					if(num == 1)
						peoples.add(new People(idx++, i, j));
					else if(num > 1)
						stairs.add(new Stair(i, j, num));
				}
			}
			
			for (int i = 0; i <= peoples.size(); i++) {
				subset(i, 0, 0, new boolean[peoples.size()]);
			}
			
			System.out.println("#"+tc+" "+answer);
			peoples.clear();
			stairs.clear();
		}
	}
	
	private static void subset(int idx, int cnt, int start, boolean[] set) {
		if(cnt == idx) {
			answer = Math.min(answer, walkDown(set));
			return;
		}
		for (int i = start; i < set.length; i++) {
			set[i] = true;
			subset(idx, cnt+1, i+1, set);
			set[i] = false;
		}
	}

	private static int walkDown(boolean[] set) {
		int size = set.length;
		for (int i = 0; i < size; i++) {
			if(set[i])
				distance(peoples.get(i), stairs.get(0));
			else
				distance(peoples.get(i), stairs.get(1));
		}
		LinkedList<People> peops = new LinkedList<People>(peoples);
		Collections.sort(peops, new Comparator<People>() {
			@Override
			public int compare(People o1, People o2) {
				return o1.time-o2.time;
			}
		});
		
		int time = 0;
		top:
		while(true) {
			time++;
			for (int i = 0; i < size; i++) {
				if(peops.get(i).time > 0)
					peops.get(i).time--;
				else if(peops.get(i).time == 0) {
					if(set[peops.get(i).idx] && stairs.get(0).using.size() < 3) {
						stairs.get(0).add(peops.get(i));
						peops.get(i).time--;
					} else if(!set[peops.get(i).idx] && stairs.get(1).using.size() < 3){
						stairs.get(1).add(peops.get(i));
						peops.get(i).time--;
					}
				} else {
					if(stairs.get(0).using.contains(peops.get(i))) {
						if(--peops.get(i).time < -stairs.get(0).time)
							stairs.get(0).using.poll();
					} else if(stairs.get(1).using.contains(peops.get(i))) {
						if(--peops.get(i).time < -stairs.get(1).time)
							stairs.get(1).using.poll();
						
					}
				}
			}
			
			for (int i = 0; i < size; i++) {
				if(set[peops.get(i).idx]) {
					if(peops.get(i).time >= -stairs.get(0).time)
						continue top;
				}
				else {
					if(peops.get(i).time >= -stairs.get(1).time)
						continue top;
				}
			}
			break;
		}
		
		return time;
		
	}

	private static void distance(People p, Stair s) {
		p.time = Math.abs(p.r - s.r) + Math.abs(p.c - s.c);
	}

	static class People{
		int idx;
		int r;
		int c;
		int time;
		public People(int idx, int r, int c) {
			this.idx = idx;
			this.r = r;
			this.c = c;
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
			using = new LinkedList<>();
		}

		public void add(People p) {
			using.add(p);
		}
	}
	
}
