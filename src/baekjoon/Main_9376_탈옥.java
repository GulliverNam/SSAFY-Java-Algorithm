package baekjoon;

import java.io.*;
import java.util.*;

public class Main_9376_탈옥 {
	
	static class JailBreak{
		int r,c;
		List<int[]> door;
		public JailBreak(int r, int c) {
			this.r = r;
			this.c = c;
			this.door = new ArrayList<int[]>();
		}
		public void add(int[] door) {
			this.door.add(door);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			char[][] map = new char[h+2][w+2];
			List<int[]> doors = new ArrayList<int[]>();
			List<int[]> sPoint = new ArrayList<int[]>();
			for (int i = 1; i <= h; i++) {
				char[] m = br.readLine().trim().toCharArray();
				for (int j = 1; j <= w; j++) {
					map[i][j] = m[j-1];
					if(i == 1 || i == h || j == 1 || j == w) {
						if(map[i][j] == '#') {
							sPoint.add(new int[] {i, j, 1});
						} else if(map[i][j] == '.') {
							sPoint.add(new int[] {i, j, 0});
						}
					} else {
						if(map[i][j] == '#') {
							doors.add(new int[] {i,j});
						}
					}
				}
			}
			Comparator<int[]> comp = new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[2],o2[2]);
				}
			};
			PriorityQueue<int[]> queue = new PriorityQueue<int[]>(comp);
			queue.addAll(sPoint);
			
			
			
		}
	}

}
