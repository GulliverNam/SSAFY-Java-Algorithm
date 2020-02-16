package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_5648_원자소멸시뮬레이션_미완성 {
	
	static int N, answer;
	static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean horizon[], vertical[];
	static LinkedList<Atom> atom;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/test/Solution_5648_원자소멸시뮬레이션.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		horizon = new boolean[2001];
		vertical = new boolean[2001];
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine().trim());
			atom = new LinkedList<>();
			answer = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				atom.add(new Atom(1000 + Integer.parseInt(st.nextToken()),
								   1000 - Integer.parseInt(st.nextToken()),
								   Integer.parseInt(st.nextToken()),
								   Integer.parseInt(st.nextToken())));
				vertical[atom.get(i).c] = true;
				horizon[atom.get(i).r] = true;
			}
			simulation();
			Arrays.fill(vertical, false);
			Arrays.fill(horizon, false);
			System.out.println(answer);
		}
	}
	
	private static void simulation() {
		int length;
		Atom cur;
		while(true) {
			length =atom.size();
			for (int i = 0; i < length; i++) {
				cur = atom.get(i);
				vertical[cur.c] = false;
				horizon[cur.r] = false;
				cur.r += dir[cur.dir][0];
				cur.c += dir[cur.dir][1];
				vertical[cur.c] = true;
				horizon[cur.r] = true;
			}
			
			atom.sort(new Comparator<Atom>() {
				@Override
				public int compare(Atom o1, Atom o2) {
					if(o1.r == o2.r)
						return o1.c - o2.c;
					return o1.r - o2.r;
				}
			});
			boolean remove = false;
			Atom prev = null;
			for (Atom a : new LinkedList<Atom>(atom)) {
				if(prev == null)
					prev = a;
				else {
					if(remove) {
						if(prev.r != a.r || prev.c != a.c) {
							remove = false;
							answer += a.energy;
							atom.remove(prev);
						}
					} else {
						if(prev.r == a.r && prev.c == a.c) {
							remove = true;
							answer += a.energy;
							atom.remove(a);
						}
						else
							prev = a;
					}
				}
			}
		}
	}

	static class Atom{
		int r;
		int c;
		int dir;
		int energy;
		public Atom(int c, int r, int dir, int energy) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.energy = energy;
		}
		@Override
		public String toString() {
			return "Atom [r=" + r + ", c=" + c + ", dir=" + dir + ", energy=" + energy + "]";
		}
		
	}

}
