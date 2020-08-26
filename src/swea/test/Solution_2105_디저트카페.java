package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_2105_디저트카페 {

	static int N, sr, sc, answer, cafes[][];
	static int dir[][] = {{1,-1},{1,1},{-1,1},{-1,-1}};
			
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/test/Solution_2105_디저트카페.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		ArrayList<Integer> list;
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			cafes = new int[N+2][N+2];
			answer = 0;
			list = new ArrayList<Integer>(2*(N-1));
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 1; j <= N; j++) {
					cafes[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			top:
			for (int i = 1; i <= N-2; i++) {
				for (int j = 1; j <= N; j++) {
					if(cafes[i+dir[0][0]][j+dir[0][1]] != 0 && cafes[i+dir[1][0]][j+dir[1][1]] != 0) {
						sr = i;
						sc = j;
						list.add(cafes[i][j]);
						tour(i, j, 0, list);
						if(answer == 2*(N-1))
							break top;
						list.clear();
					}
				}
			}
			System.out.println("#"+tc+" "+(answer == 0 ? -1:answer));
			
		}
	}

	private static void tour(int r, int c, int d, List<Integer> list) {
		int next, nr, nc;
		for (int i = d; i <= (d == 3 ? d:d+1); i++) {
			nr = r+dir[i][0];
			nc = c+dir[i][1];
			next = cafes[nr][nc];
			if(nr == sr && nc == sc) {
				answer = Math.max(answer, list.size());
				return;
			}
			if(next != 0 && !list.contains(next)) {
				list.add(next);
				tour(nr, nc, i, list);
				list.remove((Integer)next);
			}
		}
	}

}
