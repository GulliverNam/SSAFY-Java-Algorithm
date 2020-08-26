package swea.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로2 {
	
	static int N, start[], end[], places[][], answer;
	static boolean visited[];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d5/Solution_D5_1247_최적경로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			places = new int[N][2];
			visited = new boolean[N];
			st = new StringTokenizer(br.readLine().trim());
			start = new int [] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			end = new int [] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			answer = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++)
				places[i] = new int [] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			visit(start, 0, 0);
			System.out.println("#"+tc+" "+answer);
		}
	}

	private static void visit(int[] prev, int cnt, int d) {
		if(answer <= d)
			return;
		if(cnt == N) {
			answer = Math.min(answer, d+Math.abs(prev[0]-end[0])+Math.abs(prev[1]-end[1]));
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				visit(places[i], cnt+1, d+Math.abs(prev[0]-places[i][0])+Math.abs(prev[1]-places[i][1]));
				visited[i] = false;
			}
		}
		
	}
}
