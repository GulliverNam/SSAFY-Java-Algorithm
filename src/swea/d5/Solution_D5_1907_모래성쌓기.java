package swea.d5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D5_1907_모래성쌓기 {
	
	static class Node{
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int H, W, map[][];
	static int dr[] = {-1,-1,-1,0,0,1,1,1};
	static int dc[] = {-1,0,1,-1,1,-1,0,1};
	static Queue<Node> queue = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new int [H][W];
			queue.clear();
			String str;
			for (int i = 0; i < H; i++) {
				str = br.readLine().trim();
				for (int j = 0; j < W; j++) {
					if(str.charAt(j) != '.')
						map[i][j] = str.charAt(j) - '0';
				}
			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(map[i][j] == 0) {
						for (int d = 0; d < 8; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];
							if(nr > -1 && nc > -1 && nr < H && nc < W && map[nr][nc] != 0) {
								map[nr][nc]--;
								if(map[nr][nc] == 0) {
									map[nr][nc] = -1;
									queue.offer(new Node(nr,nc));
								}
							}
						}
					}
				}
			}
			int answer = 0;
			while(!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					Node node = queue.poll();
					for (int d = 0; d < 8; d++) {
						int nr = node.r + dr[d];
						int nc = node.c + dc[d];
						if(nr > -1 && nc > -1 && nr < H && nc < W && map[nr][nc] != 0) {
							map[nr][nc]--;
							if(map[nr][nc] == 0) {
								map[nr][nc] = -1;
								queue.offer(new Node(nr,nc));
							}
						}
						
					}
				}
				answer++;
			}
			System.out.println("#"+tc+" "+answer);
			
		}
	}
}
