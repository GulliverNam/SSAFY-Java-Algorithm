 package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D4_1258_행렬찾기 {
	
	static int N, map[][];
	static int dir[][] = {{0,1},{1,0}};
	static boolean visit[][];
	static LinkedList<Rect> answer;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/Solution_D4_1258_행렬찾기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N+2][N+2];
			visit = new boolean[N+2][N+2];
			answer = new LinkedList<Rect>();
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(!visit[i][j] && map[i][j] != 0) {
						find(i, j);
					}
				}
			}
			
			answer.sort(new Comparator<Rect>() {
				@Override
				public int compare(Rect o1, Rect o2) {
					if(o1.size == o2.size)
						return o1.height - o2.height;
					return o1.size - o2.size;
				}
			});
			
			System.out.print("#"+testCase+" "+answer.size()+" ");
			for (Rect r: answer)
				System.out.print(r.toString()+" ");
			System.out.println();
		}
	}

	private static void find(int r, int c) {
		int wcnt = 1, hcnt = 1;
		visit[r][c] = true;
		for (int d = 0; d < 2; d++) {
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			while(map[nr][nc] != 0) {
				visit[nr][nc] = true;
				if(d == 0) wcnt++;
				else{
					for(int i = c+1; i < c+wcnt; i++)
						visit[nr][i] = true;
					hcnt++;
				}
				nr += dir[d][0];
				nc += dir[d][1];
			}
		}
		answer.add(new Rect(hcnt, wcnt));
	}
	
	static class Rect{ // 멤버 클래스로 정의할 때 class에 static을 쓸 수 있음
		int height;
		int width;
		int size;
		
		public Rect(int height, int width) {
			this.height = height;
			this.width = width;
			this.size = height * width;
		}
		
		public String toString() {
			return this.height + " " + this.width;
		}
	}
}

