package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4340_파이프연결 {
	
	static int N, answer, map[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static boolean connect[][] = {{false,false,true,true,true,false,false},
								  {false,false,true,false,false,true,true},
								  {false,true,false,true,false,false,true},
								  {false,true,false,false,true,false,true}};
	static boolean move[][] = {{},
							   {false, false, true, true},
							   {true, true, false, false},
							   {false, true, false ,true},
							   {false, true, true, false},
							   {true, false, true, false},
							   {true, false, false, true}}; 
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/test/Solution_4340_파이프연결.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= 2; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N+2][N+2];
			answer = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			findPath(1, 1, 0, 2, new boolean[N+2][N+2]);
			System.out.println("#"+tc+" "+answer);
		}
	}
	private static void findPath(int r, int c, int cnt, int prev, boolean[][] visited) {
		System.out.println("now "+r+" "+c);
		if(r == N && c == N) {
			answer = Math.min(answer, cnt+1);
			return;
		}
		if(cnt >= answer) {
			return;
		}
		int nr, nc;
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if(move[map[r][c]][i] && connect[i][map[nr][nc]]) {
				if(map[nr][nc] != 0 && !visited[nr][nc]) {
					visited[r][c] = true;
					findPath(nr, nc, cnt+1, (i % 2 == 0 ? i+1:i-1), visited);
					visited[r][c] = false;
				}
			} else if(!move[map[r][c]][i] && connect[i][map[nr][nc]]) { // 현재 불가 다음 가능
				if(map[nr][nc] != 0 && !visited[nr][nc]) {
					int next = Math.max(prev, i);
					prev = Math.min(prev, i);
					int origin = map[r][c];
					if(map[r][c] != 1 && map[r][c] != 2) {
						if(prev != 2 && next != 1) {
							System.out.println("now change!! "+r+" "+c);
							if(prev == 1) {
								if(next == 3)
									map[r][c] = 3;
								else
									map[r][c] = 4;
							} else {
								if(next == 2)
									map[r][c] = 5;
								else
									map[r][c] = 6;
							}
							visited[r][c] = true;
							findPath(nr, nc, cnt+1, (i % 2 == 0 ? i+1:i-1), visited);
							visited[r][c] = false;
							map[r][c] = origin;
						}
					}
				}
			} else if(move[map[r][c]][i] && !connect[i][map[nr][nc]]) { // 현재 가능 다음 불가
				int origin = map[nr][nc];
				if(map[nr][nc] != 0 && !visited[nr][nc]) {
					System.out.println("next change!! "+r+" "+c);
					visited[r][c] = true;
					switch(i % 2 == 0 ? i+1:i-1) {
						case 0:
							switch(origin) {
								case 1:
									map[nr][nc] = 2;
									findPath(nr, nc, cnt+1, (i % 2 == 0 ? i+1:i-1), visited);
									break;
								case 3:
								case 4:
									for (int j : new int[] {5,6}) {
										map[nr][nc] = j;
										findPath(nr, nc, cnt+1, (i % 2 == 0 ? i+1:i-1), visited);
									}
									break;
							}
							break;
						case 1:
							switch(origin) {
								case 1:
									map[nr][nc] = 2;
									findPath(nr, nc, cnt+1, (i % 2 == 0 ? i+1:i-1), visited);
									break;
								case 5:
								case 6:
									for (int j : new int[] {3,4}) {
										map[nr][nc] = j;
										findPath(nr, nc, cnt+1, (i % 2 == 0 ? i+1:i-1), visited);
									}
									break;
							}
							break;
						case 2:
							switch(origin) {
								case 2:
									map[nr][nc] = 1;
									findPath(nr, nc, cnt+1, (i % 2 == 0 ? i+1:i-1), visited);
									break;
								case 3:
								case 6:
									for (int j : new int[] {4,5}) {
										map[nr][nc] = j;
										findPath(nr, nc, cnt+1, (i % 2 == 0 ? i+1:i-1), visited);
									}
									break;
							}
							break;
						case 3:
							switch(origin) {
								case 2:
									map[nr][nc] = 1;
									findPath(nr, nc, cnt+1, (i % 2 == 0 ? i+1:i-1), visited);
									break;
								case 4:
								case 5:
									for (int j : new int[] {3,6}) {
										map[nr][nc] = j;
										findPath(nr, nc, cnt+1, (i % 2 == 0 ? i+1:i-1), visited);
									}
									break;
							}
							break;
					}
					visited[r][c] = false;
					map[nr][nc] = origin;
				}
			}
		}
		
	}

}
