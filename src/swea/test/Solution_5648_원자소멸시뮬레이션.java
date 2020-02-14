package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_5648_원자소멸시뮬레이션 {
	
	static int N, horizon[], vertical[], map[][];
	static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static LinkedList<Atom> atom;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/test/Solution_5648_원자소멸시뮬레이션.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		map = new int[2002][2002];
		horizon = new int[2002];
		vertical = new int[2002];
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine().trim());
			atom = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				atom.add(new Atom(1000 + Integer.parseInt(st.nextToken()),
								   1000 - Integer.parseInt(st.nextToken()),
								   Integer.parseInt(st.nextToken()),
								   Integer.parseInt(st.nextToken())));
				map[atom.get(i).r][atom.get(i).c] = atom.get(i).energy;
				vertical[atom.get(i).c]++;
				horizon[atom.get(i).r]++;
			}
			simulation();
			for (int i = 1; i <= 2000; i++) {
				Arrays.fill(map[i], 0);
			}
			Arrays.fill(vertical, 0);
			Arrays.fill(horizon, 0);
		}
	}
	
	private static void simulation() {
		int length, nr, nc;
		Atom cur;
		while(true) {
			length =atom.size();
			for (int i = 0; i < length; i++) {
				cur = atom.poll();
			}
		}
	}

	static class Atom{
		int c;
		int r;
		int dir;
		int energy;
		public Atom(int c, int r, int dir, int energy) {
			this.c = c;
			this.r = r;
			this.dir = dir;
			this.energy = energy;
		}
		
	}

}
