package swea.d5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution_D5_7396_종구의딸이름짓기 {
 
    static char map[][], answer[];
    static int N, M;
    static int dir[][] = {{1,0},{0,1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine().trim());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][];
            answer = new char[N+M-1];
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().trim().toCharArray();
            }
            bfs();
            System.out.print("#"+tc+" ");
            System.out.println(answer);
        }
    }
 
    private static void bfs() {
    	Queue<int[]> queue = new LinkedList<int[]>();
    	boolean visited[][] = new boolean[N][M];
    	queue.offer(new int[] {0,0});
    	visited[0][0] = true;
    	answer[0] = map[0][0];
    	for (int i = 1; i < N+M-1; i++) {
    		int cur[];
    		char min = 'z';
    		Queue<int[]> temp = new LinkedList<int[]>();
			while(!queue.isEmpty()) {
				cur = queue.poll();
				for (int d = 0; d < 2; d++) {
					int nr = cur[0] + dir[d][0];
					int nc = cur[1] + dir[d][1];
					if(nr < N && nc < M && !visited[nr][nc]) {
						visited[nr][nc] = true;
						if(min > map[nr][nc]) {
							min = map[nr][nc];
							temp.clear();
							temp.offer(new int[] {nr,nc});
						} else if(min == map[nr][nc]) {
							temp.offer(new int[] {nr,nc});
						}
					}
				}
			}
			answer[i] = min;
			queue.addAll(temp);
		}
    	
    }
 
}