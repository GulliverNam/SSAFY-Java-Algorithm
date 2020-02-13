package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방_Solution {
	
	static int N, map[][];
	static Ans result;
	static int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/Solution_D4_1861_정사각형방.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N+2][N+2];
			result = new Ans(0,0);
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					dfs(i,j, map[i][j], 1);
				}
			}
			System.out.println("#"+testCase+" "+result.toString());
		}
	}
	
	private static void dfs(int r, int c, int pos, int cnt) {
		Ans ans = new Ans(pos, cnt);
		
		if(result.compareTo(ans) > 0)
			result = ans;
		
		int nr, nc;
		for (int i = 0; i < 4; i++) {
			nr = r + dir[i][0];
			nc = c + dir[i][1];
			if(map[nr][nc] == map[r][c]+1) {
				dfs(nr, nc, pos, cnt+1);
			}
		}
	}


	static class Ans{ 	// 2개 이상의 속성(시작번호, 이동횟수)를 저장, 독립객체
		int pos;		// 시작점의 값
		int cnt;		// 밟아온 칸의 갯수
		public Ans(int pos, int cnt) {
			this.pos = pos;
			this.cnt = cnt;
		}
		
		public int compareTo(Ans o) {
			if(o.cnt == this.cnt)
				return this.pos - o.pos;	// 카운트가 같으면 pos 가 작은 것 선택
			return o.cnt - this.cnt;		// 카운트 된 횟수정보를 리턴
		}
		
		@Override
		public String toString() {
			return this.pos + " " + this.cnt;
		}
		
	}

}
