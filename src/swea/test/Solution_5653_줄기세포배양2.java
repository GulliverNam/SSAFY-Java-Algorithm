package swea.test;

import java.io.*;
import java.util.*;

public class Solution_5653_줄기세포배양2 {
	
	static int N, M, K;
	static PriorityQueue<Cell> cells;
	static Cell[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Cell implements Comparable<Cell>{
		int r, c, vitality, age;

		public Cell(int r, int c, int vitality, int age) {
			this.r = r;
			this.c = c;
			this.vitality = vitality;
			this.age = age;
		}
		@Override
		public int compareTo(Cell o) {
			return Integer.compare(o.vitality, this.vitality);
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Cell [r=").append(r).append(", c=").append(c).append(", vitality=").append(vitality)
					.append(", age=").append(age).append("]");
			return builder.toString();
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new Cell[1000][1000];
			cells = new PriorityQueue<Cell>();
			int lenR = 1000 / 2 - N + 1;
			int lenC = 1000 / 2 - M + 1;
			for (int i = lenR; i < lenR+N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = lenC; j < lenC+M; j++) {
					int X = Integer.parseInt(st.nextToken());
					if(X != 0) {
						Cell cell = new Cell(i, j, X, X);
						map[i][j] = cell;
						cells.add(cell);
					}
				}
			}
			PriorityQueue<Cell> newCells = new PriorityQueue<Cell>();
			Cell cur;
			for (int i = 0; i < K; i++) {
				while(!cells.isEmpty()) {
					cur = cells.poll();
					cur.age--;
					if(cur.age >= -cur.vitality) {
						if(cur.age < 0) {
							for (int d = 0; d < 4; d++) {
								int nr = cur.r + dr[d];
								int nc = cur.c + dc[d];
								if(map[nr][nc] == null) {
									Cell newCell = new Cell(nr, nc, cur.vitality, cur.vitality);
									map[nr][nc] = newCell;
									newCells.add(newCell);
								}
							}
						}
						if(cur.age != -cur.vitality)
							newCells.add(cur);
					}
				}
				cells.addAll(newCells);
				newCells.clear();
			}
			bw.write("#"+tc+" "+cells.size()+"\n");
		}
		bw.flush();
		bw.close();
	}
}

