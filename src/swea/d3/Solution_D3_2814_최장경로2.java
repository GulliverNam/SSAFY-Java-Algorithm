package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_D3_2814_최장경로2 {
      
    static int N, M, answer;
    static boolean adj[][];
    // 어떤 방문체크 상태로, 어떤 정점에 도달했는지
    static int[][] memo;
    public static void main(String[] args) throws Exception{
    	System.setIn(new FileInputStream("res/swea/d3/Solution_D3_2814_최장경로.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine().trim());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            adj = new boolean[N+1][N+1];
            answer = 1;
            memo = new int[1 << (N+1)][N+1];
            int prev, next;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine().trim());
                prev = Integer.parseInt(st.nextToken());
                next = Integer.parseInt(st.nextToken());
                adj[prev][next] = true;
                adj[next][prev] = true;
            }
            for (int i = 1; i <= N; i++) {
                answer = Math.max(answer, dfs(i, 1<<i));
            }
            System.out.println("#"+tc+" "+answer);
        }
    }
  
    private static int dfs(int v, int visited) {
    	if(memo[visited][v] != 0)
    		return memo[visited][v];
        int ret = 1;
        for (int i = 1; i <= N; i++) {
            if( adj[v][i] && (visited & (1<<i)) == 0) {
                ret = Math.max(ret, dfs(i, visited | (1<<i)) + 1);
            }
        }
        memo[visited][v] = ret;
        return ret;
    }
  
}
