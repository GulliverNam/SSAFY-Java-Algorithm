package baekjoon;

import java.io.*;
import java.util.*;

public class Main_19236_청소년상어 {
	
	static class Fish{
		int r;
		int c;
		int num;
		int dir;
		public Fish(int r, int c, int num, int dir) {
			this.r = r;
			this.c = c;
			this.num = num;
			this.dir = dir;
		}
		@Override
		public String toString() {
			return "[" + num + ", " + dir + "]";
		}
		
		
		
	}
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,-1,-1,-1,0,1,1,1};
	static int answer;
	public static void main(String[] args) throws Exception {
		// 한칸에 물고기 1마리 (번호, 방향)
		// - 1 <= 번호 <= 16
		// 방향 8방
		
		// 상어 -> (0,0) 물고기가 있는 공간에 들어가 물고기를 먹음 -> 상어방향: 해당칸의 물고기 방향
		
		
		// 물고기의 이동이 끝나면 상어가 이동
		// - 한번에 여러개의 칸 이동 가능
		// - 물고기가 있는 칸이면 물고기를 먹고 방향을 가짐
		// - 물고기가 없는 칸으로는 이동할 수 없음
		// if) 상어가 이동할 수 있는 칸이 없으면 공간에서 벗어나 집으로 간다
		// - 상어 이동후 다시 물고기 이동
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Fish[][] fishes = new Fish[4][4];
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < 4; j++) {
				Fish fish = new Fish(i,j,Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())-1);
				fishes[i][j] = fish;
			}
		}
		
		int[] shark = new int[] {0, 0, fishes[0][0].dir};
		int num = fishes[0][0].num;
		fishes[0][0] = null;
		eatFish(shark, fishes, num);
		
		System.out.println(answer);
		
	}

	private static void eatFish(int[] shark, Fish[][] fishes, int cnt) {
		Fish[][] curF = new Fish[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if(fishes[i][j] != null) {
					Fish tmp = fishes[i][j];
					curF[i][j] = new Fish(tmp.r, tmp.c, tmp.num, tmp.dir);
				}
			}
		}
		moveFish(shark, curF);
		int nr = shark[0];
		int nc = shark[1];
		while(true) {
			nr += dr[shark[2]];
			nc += dc[shark[2]];
			if(!isIn(nr,nc)) {
				answer = Math.max(answer, cnt);
				return;
			}
			if(curF[nr][nc] != null) {
				Fish f = curF[nr][nc];
				curF[f.r][f.c] = null;
				eatFish(new int[] {f.r,f.c,f.dir}, curF, cnt + f.num);
				curF[f.r][f.c] = f;
			} else {
				answer = Math.max(answer, cnt);
				continue;
			}
		}
	}

	// 물고기 이동
	// - 번호가 작은 물고기부터 이동
	// - 한칸 이동 가능
	// 이동할 수 있는 칸을 향할때까지 방향을 45도 반시계로 회전
	// - 이동할 수 없는 칸: 상어가있는칸, 경계밖
	// if) 물고기가 있는 칸 -> 서로 위치를 바꾸는 방식으로 이동
	private static void moveFish(int[] shark, Fish[][] fishes) {
		PriorityQueue<Fish> tmp = new PriorityQueue<>(new Comparator<Fish>() {
			@Override
			public int compare(Fish o1, Fish o2) {
				return Integer.compare(o1.num, o2.num);
			}
		});
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if(fishes[i][j] != null) {
					tmp.add(fishes[i][j]);
				}
			}
		}
		while(!tmp.isEmpty()) {
			Fish cur = tmp.poll();
			int nr = 0;
			int nc = 0;
			while(true) {
				nr = cur.r + dr[cur.dir];
				nc = cur.c + dc[cur.dir];
				if(isIn(nr, nc) && !(nr == shark[0] && nc == shark[1])) {
					break;
				} else {
					cur.dir = (cur.dir + 1) % 8;
				}
			}
			if(fishes[nr][nc] == null) {
				fishes[cur.r][cur.c] = null;
				fishes[nr][nc] = cur;
			} else {
				Fish other = fishes[nr][nc];
				fishes[nr][nc] = cur;
				fishes[cur.r][cur.c] = other;
				other.r = cur.r;
				other.c = cur.c;
			}
			cur.r = nr;
			cur.c = nc;
			
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr > -1 && nr < 4 && nc > -1 && nc < 4;
	}
	
	

}
