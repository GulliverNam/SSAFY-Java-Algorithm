package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {
	
	static int users[][][], M, A;
	static int dir[][] = {{0,0},{-1,0},{0,1},{1,0},{0,-1}};
	static Map map[][];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/test/Solution_5644_무선충전.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			users = new int[M+1][2][2];
			users[0][0] = new int[] {1,1};
			users[0][1] = new int[] {10,10};
			map = new Map[11][11];
			user(new StringTokenizer(br.readLine().trim()), 0);
			user(new StringTokenizer(br.readLine().trim()), 1);
			
			int r, c, range;
			BC bc;
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine().trim());
				c = Integer.parseInt(st.nextToken());
				r = Integer.parseInt(st.nextToken());
				range = Integer.parseInt(st.nextToken());
				bc = new BC(Integer.parseInt(st.nextToken()));
				for (int j = -range; j <= range; j++) {
					for (int k = -(range - Math.abs(j)); k <= range - Math.abs(j); k++) {
						if(r+j > 0 && c+k > 0 && r+j < 11 && c+k < 11) {
							if(map[r+j][c+k] == null)
								map[r+j][c+k] = new Map();
							map[r+j][c+k].add(bc);
						}
					}
				}
			}
			
			LinkedList<Map> select = new LinkedList<>();
			Map cur;
			int answer = 0;
			for (int i = 0; i <= M; i++) {
				for (int j = 0; j < 2; j++) {
					cur = map[users[i][j][0]][users[i][j][1]];
					if(cur != null) {
						select.add(cur);
					}
				}
				switch(select.size()) {
				case 0:
					break;
				case 1:
					answer += select.get(0).bc.get(0).power;
					break;
				case 2:
					LinkedList<BC> p1 = new LinkedList<BC>(select.get(0).bc);
					LinkedList<BC> p2 = new LinkedList<BC>(select.get(1).bc);
					answer += p1.get(0).power;
					if(p1.get(0) == p2.get(0)) {
						if(p1.size() < 2 && p2.size() < 2)
							break;
						else if(p1.size() < 2)
							answer += p2.get(1).power;
						else if(p2.size() < 2)
							answer += p1.get(1).power;
						else
							answer += (p1.get(1).power > p2.get(1).power ? p1.get(1).power : p2.get(1).power);
					}
					else
						answer += p2.get(0).power;
					break;
				}
				select.clear();
			}
			System.out.println("#"+tc+" "+answer);
			
		}
		
	}
	
	private static void user(StringTokenizer st, int p) {
		for (int i = 1; i <= M; i++) {
			int d = Integer.parseInt(st.nextToken());
			users[i][p][0] = users[i-1][p][0] + dir[d][0];
			users[i][p][1] = users[i-1][p][1] + dir[d][1];
		}
	}
	
	static class BC{
		int power;
		public BC(int power) {
			this.power = power;
		}
	}
	
	static class Map{
		LinkedList<BC> bc;
		public Map() {
			bc = new LinkedList<>();
		}
		public void add(BC b) {
			bc.add(b);
			bc.sort(new Comparator<BC>() {
				@Override
				public int compare(BC o1, BC o2) {
					if(o1.power < o2.power)
						return 1;
					else if(o1.power == o2.power)
						return 0;
					return -1;
				}
			});
		}
	}
}
