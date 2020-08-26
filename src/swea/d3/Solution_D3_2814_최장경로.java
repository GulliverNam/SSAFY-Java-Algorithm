package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_D3_2814_최장경로 {
      
    static int N, M, answer;
    static boolean graph[][] = new boolean[11][11];
    static boolean visited[] = new boolean[11];
      
    public static void main(String[] args) throws Exception{
    	System.setIn(new FileInputStream("res/swea/d3/Solution_D3_2814_최장경로.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine().trim());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            answer = 1;
            int prev, next;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine().trim());
                prev = Integer.parseInt(st.nextToken());
                next = Integer.parseInt(st.nextToken());
                graph[prev][next] = true;
                graph[next][prev] = true;
            }
            for (int i = 1; i <= N; i++) {
            	visited[i] = true;
                findPath(i, 1);
                if(answer == N)
                	break;
                visited[i] = false;
            }
            System.out.println("#"+tc+" "+answer);
        }
    }
  
    private static void findPath(int prev, int cnt) {
        boolean finish = true;
        for (int i = 1; i <= N; i++) {
            if(!visited[i] && graph[prev][i]) {
                finish = false;
                visited[i] = true;
                findPath(i, cnt+1);
                visited[i] = false;
            }
        }
        if(finish)
            answer = Math.max(answer, cnt);
    }
  
}
